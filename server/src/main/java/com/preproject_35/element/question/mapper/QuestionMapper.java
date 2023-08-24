package com.preproject_35.element.question.mapper;

import com.preproject_35.element.question.Dto.QuestionPatchDto;
import com.preproject_35.element.question.Dto.QuestionPostDto;
import com.preproject_35.element.question.Dto.QuestionResponseDto;
import com.preproject_35.element.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    @Mapping(source = "answers", target = "answers")
    QuestionResponseDto questionToQuestionResponseDto(Question question);
}
