package com.preproject_35.element.member.Dto;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MemberDto {

    //private long memberId;
    private String email;
    private String username;
    private String password;

    /*
    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }


     */
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
