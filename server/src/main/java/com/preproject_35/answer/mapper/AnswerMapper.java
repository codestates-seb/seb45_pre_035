package com.preproject_35.answer.mapper;

import com.preproject_35.answer.dto.AnswerPatchDto;
import com.preproject_35.answer.dto.AnswerPostDto;
import com.preproject_35.answer.dto.AnswerResponseDto;
import com.preproject_35.answer.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
