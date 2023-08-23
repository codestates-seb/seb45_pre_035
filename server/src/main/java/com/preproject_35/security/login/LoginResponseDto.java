package com.preproject_35.security.login;

public class LoginResponseDto {
    private boolean success;
    private String message;
    private String username;
    private String email;
    private long memberId;

    public LoginResponseDto() {}

    public LoginResponseDto(boolean success, String message, String username, String email, long memberId) {
        this.success = success;
        this.message = message;
        this.username = username;
        this.email = email;
        this.memberId = memberId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
