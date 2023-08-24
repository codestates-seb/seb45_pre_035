package com.preproject_35.element.question.controller;

import com.preproject_35.element.question.Dto.QuestionDeleteDto;
import com.preproject_35.element.question.Dto.QuestionPatchDto;
import com.preproject_35.element.question.Dto.QuestionPostDto;
import com.preproject_35.element.question.Dto.QuestionResponseDto;
import com.preproject_35.element.question.entity.Question;
import com.preproject_35.element.question.mapper.QuestionMapper;
import com.preproject_35.element.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    // 질문 등록
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto) {

        Question response = questionService.createQuestion(mapper.questionPostDtoToQuestion(questionPostDto));

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response), HttpStatus.CREATED);
    }

    // 질문 수정
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Min(1) long questionId,
                                        @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);

        Question response = questionService.updateQuestion(mapper.questionPatchDtoToQuestion(questionPatchDto));

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response), HttpStatus.OK);
    }

    // 내 질문 목록 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMyQuestion(@PathVariable("member-id") long memberId) {

        List<Question> questions = questionService.findMyQuestion(memberId); // member 와 엔티티 연관관계 매핑 필요

        List<QuestionResponseDto> response =
                questions.stream()
                        .map(question -> mapper.questionToQuestionResponseDto(question))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 질문 목록 조회
    @GetMapping
    public ResponseEntity getQuestions() {
        List<Question> questions = questionService.findQuestions();

        List<QuestionResponseDto> response =
                questions.stream()
                        .map(question -> mapper.questionToQuestionResponseDto(question))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 질문 삭제
    @DeleteMapping("{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") long questionId,
                                         QuestionDeleteDto questionDeleteDto) {

        questionService.deleteQuestion(questionId);

        return new ResponseEntity(questionDeleteDto, HttpStatus.OK);
    }
}
