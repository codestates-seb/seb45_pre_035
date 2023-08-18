package com.preproject_35.question.controller;

import com.preproject_35.question.Dto.QuestionPatchDto;
import com.preproject_35.question.Dto.QuestionPostDto;
import com.preproject_35.question.Dto.QuestionResponseDto;
import com.preproject_35.question.mapper.QuestionMapper;
import com.preproject_35.question.entity.Question;
import com.preproject_35.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAuthority('QUESTION_WRITE')")
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

        Question question = mapper.questionPostDtoToQuestion(questionPostDto); // 타이틀, 내용

        Question response = questionService.createQuestion(question); // 엔티티로

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response), HttpStatus.CREATED);
    }

    // 질문 수정
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") long questionId,
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
    public ResponseEntity deleteQuestion(@PathVariable("question-id") long questionId) {

        questionService.deleteQuestion(questionId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
