package com.preproject_35.element.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerPostDto {
    // 답변 등록 시, 입력 받아야 할 것
    //@Email
    //private String email;
    @NotBlank
    private String content;
}
