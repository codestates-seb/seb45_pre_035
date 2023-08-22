package com.preproject_35.element.answer.controller;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.mapper.AnswerMapper;
import com.preproject_35.element.answer.service.AnswerService;
import com.preproject_35.security.auth.userdetails.MemberDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", exposedHeaders = "*")
@Slf4j
@Validated
@RestController
@RequestMapping("/questions")
public class AnswerController {

    private final AnswerMapper answerMapper;
    private final AnswerService answerService;

    public AnswerController(AnswerMapper answerMapper, AnswerService answerService) {
        this.answerMapper = answerMapper;
        this.answerService = answerService;
    }
    // 답변 등록
    @PostMapping("/{question-id}/answers")
        public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId,
                                         @Valid @RequestBody AnswerPostDto answerPostDto,
                                         @AuthenticationPrincipal MemberDetailsService.MemberDetails memberDetails) {

        if (memberDetails != null) {
            Answer answer = answerService.createAnswer(answerMapper.answerPostDtoToAnswer(answerPostDto), memberDetails, questionId);

            return new ResponseEntity<>(answerMapper.answerToAnswerPostResponseDto(answer), HttpStatus.CREATED);
        }   else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 답변 수정
    @PatchMapping("/{question-id}/answers/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("question-id") @Positive long questionId,
                                      @PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerPatchDto answerPatchDto,
                                      @AuthenticationPrincipal MemberDetailsService.MemberDetails memberDetails) {
        if (memberDetails != null) {
            Answer answer = answerMapper.answerPatchDtoToAnswer(answerPatchDto);
            answer.setAnswerId(answerId);

            Answer updateAnswer = answerService.updateAnswer(answer, memberDetails.getMemberId());

            return new ResponseEntity<>(answerMapper.answerToAnswerPatchResponseDto(updateAnswer), HttpStatus.OK);
        }   else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 답변 조회
    @GetMapping("/{question-id}/answers/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("question-id") @Positive long questionId,
                                    @PathVariable("answer-id") @Positive long answerId) {

        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }

    // 답변 목록 조회
    @GetMapping("/{question-id}/answers")
    public  ResponseEntity getAnswers(@PathVariable("question-id") @Positive long questionId) {
        List<Answer> answers = answerService.findAnswerByQuestionId(questionId);

        List<AnswerResponseDto> response =
                answers.stream()
                        .map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // 답변 삭제
    @DeleteMapping("/{question-id}/answers/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("question-id") @Positive long questionId,
                                       @PathVariable("answer-id") @Positive long answerId,
                                       @AuthenticationPrincipal MemberDetailsService.MemberDetails memberDetails) {
        if (memberDetails != null) {
            answerService.deleteAnswer(answerId, memberDetails.getMemberId());

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }   else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
