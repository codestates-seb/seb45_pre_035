package com.preproject_35.question.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class QuestionPatchDto {
    private long questionId;
    @NotEmpty(message = "Title cannot be blank")
    private String title;
    @NotEmpty(message = "Content cannot be blank")
    private String content;
}
