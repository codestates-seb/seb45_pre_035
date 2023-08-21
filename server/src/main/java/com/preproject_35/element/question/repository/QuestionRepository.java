package com.preproject_35.element.question.repository;

import com.preproject_35.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestionId(Long questionId);
    List<Question> findByMemberId(Long memberId);
}
