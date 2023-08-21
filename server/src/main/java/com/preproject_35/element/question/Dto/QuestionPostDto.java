package com.preproject_35.element.question.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionPostDto {
    @NotEmpty(message = "Title cannot be blank")
    private String title;
    @NotEmpty(message = "Content cannot be blank")
    private String content;
}
