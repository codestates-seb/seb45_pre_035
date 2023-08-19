package com.preproject_35.element.question.service;

import com.preproject_35.element.question.entity.Question;
import com.preproject_35.element.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> findQuestion.setTitle(title));
        Optional.ofNullable(question.getContent())
                .ifPresent(content -> findQuestion.setContent(content));

        return questionRepository.save(findQuestion);
    }

    public List<Question> findMyQuestion(long memberId) {

        return findMyVerifiedQuestions(memberId);
    }

    public List<Question> findQuestions() {

        return questionRepository.findAll();
    }

    public void deleteQuestion(long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findQuestion);
    }

    // 존재하는 question 인지 검증
    private Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion =
                questionRepository.findByQuestionId(questionId);
        Question findQuestion = optionalQuestion.orElse(null);

        return findQuestion;
    }

    // 나의 질문 목록 검증
    private List<Question> findMyVerifiedQuestions(Long memberId) {
        List<Question> myQuestions = questionRepository.findByMemberId(memberId);

        return myQuestions;
    }
}
