package com.preproject_35.element.question.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class QuestionResponseDto {
    private long questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean success;
    private long memberId;
    private String author;
}
