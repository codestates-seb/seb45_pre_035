package com.preproject_35.element.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerPostDto {
    // 답변 등록 시, 입력 받아야 할 것
<<<<<<< HEAD
    //@Email
    //private String email;
=======
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
    @NotBlank
    private String content;
}
