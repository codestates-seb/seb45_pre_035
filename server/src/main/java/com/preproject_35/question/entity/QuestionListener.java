package com.preproject_35.question.entity;

import com.preproject_35.question.entity.Question;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class QuestionListener {
    @PrePersist
    public void setCreatedAt(Question question) {
        question.setCreatedAt(LocalDateTime.now());
    }
}
