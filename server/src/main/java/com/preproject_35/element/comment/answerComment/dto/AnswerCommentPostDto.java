package com.preproject_35.element.comment.answerComment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerCommentPostDto {
    @Email
    private String email;
    private String content;
}
