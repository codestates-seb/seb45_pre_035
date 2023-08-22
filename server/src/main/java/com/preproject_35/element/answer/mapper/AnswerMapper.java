package com.preproject_35.element.answer.mapper;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.member.Entity.Member;
import com.preproject_35.element.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    // PostDto -> 엔티티로
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    // PatchDto -> 엔티티로
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    // 엔티티 -> AnswerResponseDto로
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);

    // 엔티티 -> PostAnswer ResponseDto로
    default AnswerResponseDto answerToAnswerPostResponseDto(Answer answer) {
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setSuccess(true);
        answerResponseDto.setMessage("답변이 등록되었습니다.");
        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setContent(answer.getContent());
        answerResponseDto.setCreateAt(answer.getCreatedAt());
        answerResponseDto.setAuthor(answer.getMember().getUsername());
        answerResponseDto.setMemberId(answer.getMember().getMemberId());
        return answerResponseDto;
    }
    // 엔티티 -> PatchAnswer ResponseDto로
    default AnswerResponseDto answerToAnswerPatchResponseDto(Answer answer) {
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setSuccess(true);
        answerResponseDto.setMessage("답변이 수정되었습니다.");
        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setContent(answer.getContent());
        answerResponseDto.setCreateAt(answer.getCreatedAt());
        answerResponseDto.setAuthor(answer.getMember().getUsername());
        answerResponseDto.setMemberId(answer.getMember().getMemberId());
        return answerResponseDto;
    }
}