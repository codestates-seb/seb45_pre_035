package com.preproject_35.element.comment.answerComment.controller;

import com.preproject_35.answerComment.dto.AnswerCommentPatchDto;
import com.preproject_35.answerComment.dto.AnswerCommentPostDto;
import com.preproject_35.answerComment.dto.AnswerCommentResponseDto;
import com.preproject_35.answerComment.service.AnswerCommentService;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.service.AnswerService;
import com.preproject_35.element.comment.answerComment.entitiy.AnswerComment;
import com.preproject_35.element.comment.answerComment.mapper.AnswerCommentMapper;
import com.preproject_35.element.member.Entity.Member;
import com.preproject_35.element.member.Repository.MemberRepository;
import com.preproject_35.element.member.Service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/questions")
public class AnswerCommentController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final AnswerCommentMapper answerCommentMapper;
    private final AnswerCommentService answerCommentService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final AnswerService answerService;

    @PostMapping("/{question-id}/answers/{answer-id}/comments")
    public ResponseEntity postAnswerComment(@PathVariable("question-id") @Positive long questionId,
                                            @PathVariable("answer-id") @Positive long answerId,
                                            @Valid @RequestBody AnswerCommentPostDto answerCommentPostDto) throws ChangeSetPersister.NotFoundException {

        Optional<Member> findMember = memberRepository.findByEmail(answerCommentPostDto.getEmail());
        Member member = findMember.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Answer findAnswer = answerService.findAnswer(answerId);
        AnswerComment answerComment = answerCommentMapper.answerCommentPostDtoToAnswerComment(answerCommentPostDto, member, findAnswer);

        answerCommentService.createAnswerComment(answerComment);

        AnswerCommentResponseDto answerCommentResponseDto = answerCommentMapper.answerCommentToAnswerCommentPostResponseDto(answerComment);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question_id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.created(location).body(answerCommentResponseDto);
    }

    @PatchMapping("/{question-id}/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity patchAnswerComment(@PathVariable("question-id") @Positive long questionId,
                                             @PathVariable("answer-id") @Positive long answerId,
                                             @PathVariable("comment-id") @Positive long answerCommentId,
                                             @RequestBody AnswerCommentPatchDto answerCommentPatchDto) throws ChangeSetPersister.NotFoundException{

        Optional<Member> findMember = memberRepository.findByEmail(answerCommentPatchDto.getEmail());
        Member member = findMember.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Answer findAnswer = answerService.findAnswer(answerId);
        AnswerComment answerComment = answerCommentMapper.answerCommentPatchDtoToAnswerComment(answerCommentPatchDto, member, findAnswer);

        answerCommentService.updateAnswerComment(answerComment);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question_id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.created(location).body(answerCommentPatchDto);

    }

    @DeleteMapping("/{question-id}/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity deleteAnswerComment(@PathVariable("question-id") @Positive long questionId,
                                              @PathVariable("answer-id") @Positive long answerId,
                                              @PathVariable("comment-id") @Positive long answerCommentId) {

        answerCommentService.deleteAnswerComment(answerId, answerCommentId);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question_id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.ok().location(location).build();
    }
}
