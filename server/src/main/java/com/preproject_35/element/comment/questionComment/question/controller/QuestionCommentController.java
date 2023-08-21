package com.preproject_35.element.comment.questionComment.question.controller;

import com.preproject_35.comment.question.dto.QuestionCommentResponseDto;
import com.preproject_35.comment.question.entity.QuestionComment;
import com.preproject_35.comment.question.dto.QuestionCommentPatchDto;
import com.preproject_35.comment.question.dto.QuestionCommentPostDto;
import com.preproject_35.comment.question.mapper.QuestionCommentMapper;
import com.preproject_35.comment.question.service.QuestionCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionCommentController {
    private final QuestionCommentService questionCommentService;
    private final QuestionCommentMapper mapper;

    public QuestionCommentController(QuestionCommentService questionCommentService,
                                     QuestionCommentMapper mapper) {
        this.questionCommentService = questionCommentService;
        this.mapper = mapper;
    }

    // 질문 댓글 등록
    @PostMapping("/{question-id}/comments")
    public ResponseEntity postQuestionComment(@PathVariable("question-id") long questionId,
                                              @RequestBody QuestionCommentPostDto questionCommentPostDto) {

        QuestionComment questionComment = mapper.questionCommentPostDtoToQuestionComment(questionCommentPostDto);

        QuestionComment response = questionCommentService.createQuestionComment(questionComment);

        return new ResponseEntity<>(mapper.questionCommentToQuestionCommentResponseDto(response), HttpStatus.CREATED);
    }

    // 질문 댓글 수정
    @PatchMapping("/{question-id}/comments/{comment-id}")
    public ResponseEntity patchQuestionComment(@PathVariable("question-id") long questionId,
                                               @PathVariable("comment-id") long questionCommentId,
                                               @RequestBody QuestionCommentPatchDto questionCommentPatchDto) {

        questionCommentPatchDto.setQuestionCommentId(questionCommentId);

        QuestionComment response =
                questionCommentService.updateQuestionComment(mapper.questionCommentPatchDtoToQuestionComment(questionCommentPatchDto));

        return new ResponseEntity<>(mapper.questionCommentToQuestionCommentResponseDto(response), HttpStatus.OK);
    }

    // 질문 댓글 조회
    @GetMapping("/{question-id}/comments")
    public ResponseEntity getQuestionComment(@PathVariable("question-id") long questionId) {
        List<QuestionComment> questionComments = questionCommentService.findQuestionComments();

        List<QuestionCommentResponseDto> response =
                questionComments.stream()
                        .map(questionComment -> mapper.questionCommentToQuestionCommentResponseDto(questionComment))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 질문 댓글 삭제
    @DeleteMapping("/{question-id}/comments/{comment-id}")
    public ResponseEntity deleteQuestionComment(@PathVariable("question-id") long questionId,
                                                @PathVariable("comment-id") long questionCommentId) {

        questionCommentService.deleteQuestionComment(questionCommentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
