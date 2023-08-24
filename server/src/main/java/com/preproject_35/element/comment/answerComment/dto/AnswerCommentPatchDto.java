package com.preproject_35.answerComment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerCommentPatchDto {
    private long AnswerCommentId;

    @Email
    private String email;
    @NotBlank
    private String content;
}
