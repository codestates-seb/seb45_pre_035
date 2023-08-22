package com.preproject_35.element.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class AnswerPatchDto {
    // 답변 수정 시 입력 받아야 할 것
    private long answerId;

    @NotBlank
    private String content;
}