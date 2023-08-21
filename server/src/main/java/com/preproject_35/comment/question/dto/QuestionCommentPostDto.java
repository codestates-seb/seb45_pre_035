package com.preproject_35.comment.question.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class QuestionCommentPostDto {

    @NotBlank(message = "Content cannot be blank")
    private String content;

}
