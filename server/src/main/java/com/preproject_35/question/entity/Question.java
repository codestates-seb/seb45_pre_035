package com.preproject_35.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(QuestionListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    private long memberId; // 외래키
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean success = true;
}
