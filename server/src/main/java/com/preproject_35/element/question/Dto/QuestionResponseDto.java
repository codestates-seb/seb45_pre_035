package com.preproject_35.element.question.Dto;

import com.preproject_35.element.answer.dto.AnswerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuestionResponseDto {
    private boolean success = true;
    private String message = "질문이 등록되었습니다.";
    private long questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String username;
    private long memberId;
    private List<AnswerResponseDto> answers;
}
