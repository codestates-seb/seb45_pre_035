package com.preproject_35.element.comment.questionComment.question.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class QuestionCommentPatchDto {
    private long questionCommentId;
    @NotBlank(message = "Content cannot be blank")
    private String content;

}
