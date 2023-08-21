package com.preproject_35.error;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(false,404, "Member Not Found"),
    MEMBER_EXISTS(false,200,"OK"),
    QUESTION_NOT_FOUND(false,404, "Question Not Found");

    @Getter
    private boolean success;
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(boolean success, int status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }
}
