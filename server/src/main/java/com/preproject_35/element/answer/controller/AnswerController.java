package com.preproject_35.element.answer.controller;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.mapper.AnswerMapper;
import com.preproject_35.element.answer.service.AnswerService;
import com.preproject_35.element.member.entity.Member;
import com.preproject_35.element.member.Repository.MemberRepository;
import com.preproject_35.element.question.entity.Question;
import com.preproject_35.element.question.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.Optional;

@Slf4j
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/questions")
public class AnswerController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final AnswerMapper answerMapper;
    private final AnswerService answerService;
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    // 답변 등록
    @PostMapping("/{question-id}/answers")
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId,
                                     @Valid @RequestBody AnswerPostDto answerPostDto) throws ChangeSetPersister.NotFoundException {
        Optional<Question> findQuestion = questionRepository.findByQuestionId(questionId);
        Optional <Member> findMember = memberRepository.findByEmail(answerPostDto.getEmail());
        Question question = findQuestion.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Member member = findMember.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto, question, member);
        answerService.createAnswer(answer);

        AnswerResponseDto answerResponseDto = answerMapper.answerToAnswerPostResponseDto(answer);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question-id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.created(location).body(answerResponseDto);
    }

    // 답변 수정
    @PatchMapping("/{question-id}/answers/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("question-id") @Positive long questionId,
                                      @PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerPatchDto answerPatchDto) throws ChangeSetPersister.NotFoundException {
        Optional <Member> findMember = memberRepository.findByEmail(answerPatchDto.getEmail());
        Member member = findMember.orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        Answer answer = answerMapper.answerPatchDtoToAnswer(answerPatchDto, member);

        AnswerResponseDto answerResponseDto = answerMapper.answerToAnswerPatchResponseDto(answer);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question-id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.ok().location(location).body(answerResponseDto);
    }

    // 답변 삭제
    @DeleteMapping("/{question-id}/answers/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("question-id") @Positive long questionId,
                                       @PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(QUESTION_DEFAULT_URL + "/{question-id}")
                .buildAndExpand(questionId)
                .toUri();

        return ResponseEntity.ok().location(location).build();
    }
}
