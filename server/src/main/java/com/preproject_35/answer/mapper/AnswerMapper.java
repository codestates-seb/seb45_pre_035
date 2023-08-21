package com.preproject_35.answer.mapper;

import com.preproject_35.answer.dto.AnswerPatchDto;
import com.preproject_35.answer.dto.AnswerPostDto;
import com.preproject_35.answer.entity.Answer;
import com.preproject_35.member.entity.Member;
import com.preproject_35.question.entity.Question;
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
}