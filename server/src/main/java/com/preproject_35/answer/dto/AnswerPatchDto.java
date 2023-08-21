package com.preproject_35.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerPatchDto {
    // 답변 수정 시 입력 받아야 할 것
    private long answerId;

    @Email
    private String email;
    @NotBlank
    private String content;
}