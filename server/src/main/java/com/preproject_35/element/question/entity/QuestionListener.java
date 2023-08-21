package com.preproject_35.element.question.entity;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class QuestionListener {
    @PrePersist
    public void setCreatedAt(Question question) {
        question.setCreatedAt(LocalDateTime.now());
    }
}
