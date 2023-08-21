package com.preproject_35.question.Dto;

import lombok.Getter;

@Getter
public class QuestionDeleteDto {
    private boolean success = true;
    private String message = "질문이 삭제되었습니다.";
}
