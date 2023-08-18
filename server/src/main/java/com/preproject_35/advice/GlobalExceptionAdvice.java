package com.preproject_35.advice;

import com.preproject_35.answer.dto.AnswerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    public ResponseEntity<AnswerResponseDto> handleException(Exception e) {
        AnswerResponseDto responseDto = new AnswerResponseDto();
        responseDto.setSuccess(false);
        responseDto.setMessage("");

        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
