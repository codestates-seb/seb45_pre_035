package com.preproject_35.element.answer.controller;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.mapper.AnswerMapper;
import com.preproject_35.element.answer.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/answers")
@Slf4j
@Validated
public class AnswerController {

    // private final QuestionService questionService;
    // private final MemberService memberService;
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }
    // 답변 등록, 매개변수 값에 @PathVariable questionId 추가 필요
    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerPostDto answerPostDto) {

        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto);
        Answer savedAnswer = answerService.createAnswer(answer);

        AnswerResponseDto responseDto = new AnswerResponseDto();
        responseDto.setSuccess(true);
        responseDto.setMessage("답변이 등록되었습니다.");
        responseDto.setAnswerId(savedAnswer.getAnswerId());
        responseDto.setContent(savedAnswer.getContent());
        responseDto.setCreatedAt(savedAnswer.getCreateDate());
//        responseDto.setAuthor(savedAnswer.getAuthor());
//        responseDto.setMemberId(savedAnswer.getMemberId());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
//        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto);
//        Answer response = answerService.createAnswer(answer);
//
//        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(response), HttpStatus.CREATED);
    }
    // 답변 수정, 매개변수 값에 @PathVariable questionId 추가 필요
    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId, @RequestBody AnswerPatchDto answerPatchDto) {

        answerPatchDto.setAnswerId(answerId);
        Answer response = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(answerPatchDto));

        AnswerResponseDto responseDto = new AnswerResponseDto();
        responseDto.setSuccess(true);
        responseDto.setMessage("답변이 수정되었습니다.");
        responseDto.setAnswerId(response.getAnswerId());
        responseDto.setContent(response.getContent());
        responseDto.setCreatedAt(response.getCreateDate());
//        responseDto.setAuthor(updatedAnswer.getAuthor());
//        responseDto.setMemberId(updatedAnswer.getMemberId());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(response), HttpStatus.OK);
    }

    // 특정 답변 조회, 매개변수 값에 @PathVariable questionId 추가 필요
    @GetMapping("/{answer-id}")
    public ResponseEntity<AnswerResponseDto> getAnswer(@PathVariable("answer-id") Long answerId) {
        Answer answer = answerService.findAnswer(answerId);

        AnswerResponseDto responseDto = new AnswerResponseDto();
        responseDto.setSuccess(true);
        responseDto.setMessage("조회가 성공적으로 완료되었습니다.");
        responseDto.setAnswerId(answer.getAnswerId());
        responseDto.setContent(answer.getContent());
        responseDto.setCreatedAt(answer.getCreateDate());
//        responseDto.setAuthor(answer.getAuthor());
//        responseDto.setMemberId(answer.getMemberId());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 전체 답변 조회, 매개변수 값에 @PathVariable questionId 추가 필요
    @GetMapping
    public ResponseEntity<List<AnswerResponseDto>> getAnswers() {
        List<Answer> answers = answerService.findAllAnswer();

        List<AnswerResponseDto> responseDtos = answers.stream().map(answer -> {
            AnswerResponseDto responseDto = new AnswerResponseDto();
            responseDto.setSuccess(true);
            responseDto.setMessage("조회가 성공적으로 완료되었습니다.");
            responseDto.setAnswerId(answer.getAnswerId());
            responseDto.setContent(answer.getContent());
            responseDto.setCreatedAt(answer.getCreateDate());
//            responseDto.setAuthor(answer.getAuthor());
//            responseDto.setMemberId(answer.getMemberId());
            return responseDto;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }


    /*
    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long answerId) {

        Answer response = answerService.findAnswer(answerId);

        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers() {
        List<Answer> answers = answerService.findAllAnswer();
        List<AnswerResponseDto> response =
                answers.stream()
                        .map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                        .collect(Collectors.toList());

        return new ResponseEntity(response, HttpStatus.OK);
    }

     */
    // 특정 답변 삭제, 매개변수 값에 @PathVariable questionId 추가 필요
    @DeleteMapping("/{answer-id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable("answer-id") @Positive long answerId){

        answerService.deleteAnswer(answerId);

        return new ResponseEntity("답변이 삭제되었습니다.", HttpStatus.NO_CONTENT);
    }
}
