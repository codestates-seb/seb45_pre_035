package com.preproject_35.element.answer.mapper;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    // AnswerPostDto를 Answer로 변환
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    // AnswerPatchDto를 Answer로 변환
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    // Answer를 AnswerResponseDto로 변환
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
