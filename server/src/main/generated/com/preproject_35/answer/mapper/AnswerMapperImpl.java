package com.preproject_35.answer.mapper;

import com.preproject_35.answer.dto.AnswerPatchDto;
import com.preproject_35.answer.dto.AnswerPostDto;
import com.preproject_35.answer.dto.AnswerResponseDto;
import com.preproject_35.answer.entity.Answer;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T03:48:37+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setContent( answerPostDto.getContent() );

        return answer;
    }

    @Override
    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPatchDto.getAnswerId() );
        answer.setContent( answerPatchDto.getContent() );

        return answer;
    }

    @Override
    public AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        Long answerId = null;
        String content = null;

        answerId = answer.getAnswerId();
        content = answer.getContent();

        boolean success = false;
        String message = null;
        LocalDateTime createdAt = null;
        String author = null;
        Long memberId = null;

        AnswerResponseDto answerResponseDto = new AnswerResponseDto( success, message, answerId, content, createdAt, author, memberId );

        return answerResponseDto;
    }
}
