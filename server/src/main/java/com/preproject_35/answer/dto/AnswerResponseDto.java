package com.preproject_35.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class AnswerResponseDto {
    private boolean success;
    private String message;
    private Long answerId;
    private String content;
    private LocalDateTime createdAt;
    private String author;
    private Long memberId;
}
