package com.preproject_35.element.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse { // 에러 정보 담는 클래스
    private boolean success;
    private String message;
    private List<FieldError> fieldErrors;

    @Getter
    @AllArgsConstructor
    public static class FieldError { // 필드 에러 정보 클래스
        private String field;
        private String reason;
    }

    public ErrorResponse (boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
