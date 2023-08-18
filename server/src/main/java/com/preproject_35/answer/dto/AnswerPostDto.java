package com.preproject_35.answer.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
public class AnswerPostDto {

    @NotBlank(message = "답변 내용을 입력해주세요.")
    private String content;

}
