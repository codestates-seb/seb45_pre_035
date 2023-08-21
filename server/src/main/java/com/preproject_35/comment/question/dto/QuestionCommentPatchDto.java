package com.preproject_35.comment.question.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class QuestionCommentPatchDto {
    private long commentId;
    @NotBlank(message = "Content cannot be blank")
    private String content;

}
