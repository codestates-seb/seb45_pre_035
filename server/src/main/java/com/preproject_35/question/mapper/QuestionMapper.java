package com.preproject_35.question.mapper;

import com.preproject_35.question.Dto.QuestionPatchDto;
import com.preproject_35.question.Dto.QuestionPostDto;
import com.preproject_35.question.Dto.QuestionResponseDto;
import com.preproject_35.question.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToQuestionResponseDto(Question question);
}
