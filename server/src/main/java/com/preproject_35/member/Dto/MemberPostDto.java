package com.preproject_35.member.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberPostDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String username;
    @NotBlank(message = "비밀번호는 영어에 숫자 특수문자를 포함시켜주세요")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
