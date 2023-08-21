package com.preproject_35.comment.question.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

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
