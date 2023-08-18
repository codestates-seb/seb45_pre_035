package com.preproject_35.answer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AnswerPatchDto {

    private long answerId;

    @NotBlank
    private String content;
}