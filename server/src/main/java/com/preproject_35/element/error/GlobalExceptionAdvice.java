package com.preproject_35.element.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice // 컨트롤러 예외처리
public class GlobalExceptionAdvice {

    // 유효성 검증 예외처리
    @ExceptionHandler
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        List<ErrorResponse.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponse.FieldError(
                                error.getField(),
                                error.getDefaultMessage()))
                        .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse( false, "질문 등록에 실패하였습니다.", errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e) {

        ErrorResponse errorResponse = new ErrorResponse(false,"작성된 질문이 없습니다.");

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
