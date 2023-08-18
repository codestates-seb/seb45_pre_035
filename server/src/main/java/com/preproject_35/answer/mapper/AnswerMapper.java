package com.preproject_35.answer.mapper;

import com.preproject_35.answer.dto.AnswerPatchDto;
import com.preproject_35.answer.dto.AnswerPostDto;
import com.preproject_35.answer.dto.AnswerResponseDto;
import com.preproject_35.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    // AnswerPostDto를 Answer로 변환
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    // AnswerPatchDto를 Answer로 변환
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    // Answer를 AnswerResponseDto로 변환
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
