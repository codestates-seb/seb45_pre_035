package com.preproject_35.answer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerResponseDto {
    // 질문 등록, 수정, 조회 시, 응답으로 보여줄 것
    private boolean success;
    private String message;
    private long answerId;
    private String content;
    private LocalDateTime createAt;
    private String author;
    private long memberId;
}
