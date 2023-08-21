package com.preproject_35.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
@AllArgsConstructor
public class MemberPostDto {
    @Email
    private String email;
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String username;
    @NotBlank(message = "비밀번호는 영어에 숫자 특수문자를 포함시켜주세요")
    private String password;
}