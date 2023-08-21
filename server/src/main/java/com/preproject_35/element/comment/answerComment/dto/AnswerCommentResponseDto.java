package com.preproject_35.answerComment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerCommentResponseDto {
    private boolean success;
    private String message;
    private long answerCommentId;
    private String content;
    private LocalDateTime createAt;
    private String author;
    private long memberId;
}
