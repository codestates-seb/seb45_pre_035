package com.preproject_35.element.comment.questionComment.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class QuestionCommentResponseDto {
    private boolean success = true;
    private String content;
    private LocalDateTime createdAt;
    private String username;
    private long questionCommentId;
}
