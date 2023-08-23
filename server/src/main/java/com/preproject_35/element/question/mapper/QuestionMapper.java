package com.preproject_35.element.question.mapper;

import com.preproject_35.element.question.Dto.QuestionPatchDto;
import com.preproject_35.element.question.Dto.QuestionPostDto;
import com.preproject_35.element.question.Dto.QuestionResponseDto;
import com.preproject_35.element.question.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);
}
