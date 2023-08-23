package com.preproject_35.element.answer.mapper;

import com.preproject_35.element.answer.dto.AnswerPatchDto;
import com.preproject_35.element.answer.dto.AnswerPostDto;
import com.preproject_35.element.answer.dto.AnswerResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.member.entity.Member;
import com.preproject_35.element.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    // post content 와 Question 과 Member 정보가 연관된 Answer 객체로 변환하는 mapper
    default Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto, Question question, Member member) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setMember(member);
        answer.setContent(answerPostDto.getContent());
        return answer;
    }
    // patch content 와 Member 정보가 연관된 Answer 객체로 변환하는 mapper
    default Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto, Member member) {
        Answer answer = new Answer();
        answer.setAnswerId(answerPatchDto.getAnswerId());
        answer.setMember(member);
        answer.setContent(answerPatchDto.getContent());
        return answer;
    }
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

    default AnswerResponseDto answerToAnswerPatchResponseDto(Answer answer) {
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setSuccess(true);
        answerResponseDto.setMessage("답변이 수정되었습니다.");
        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setContent(answer.getContent());
        answerResponseDto.setCreateAt(answer.getModifiedAt());
        answerResponseDto.setAuthor(answer.getMember().getUsername());
        answerResponseDto.setMemberId(answer.getMember().getMemberId());
        return answerResponseDto;
    }

    default AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setSuccess(true);
        answerResponseDto.setMessage("답변이 조회되었습니다.");
        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setContent(answer.getContent());
        answerResponseDto.setCreateAt(answer.getCreatedAt());
        answerResponseDto.setAuthor(answer.getMember().getUsername());
        answerResponseDto.setMemberId(answer.getMember().getMemberId());
        return answerResponseDto;
    }

}