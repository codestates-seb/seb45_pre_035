package com.preproject_35.question.mapper;

import com.preproject_35.question.Dto.QuestionPatchDto;
import com.preproject_35.question.Dto.QuestionPostDto;
import com.preproject_35.question.Dto.QuestionResponseDto;
import com.preproject_35.question.entity.Question;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T02:19:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( questionPostDto.getTitle() );
        question.setContent( questionPostDto.getContent() );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setTitle( questionPatchDto.getTitle() );
        question.setContent( questionPatchDto.getContent() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        long questionId = 0L;
        String title = null;
        String content = null;
        LocalDateTime createdAt = null;
        boolean success = false;
        long memberId = 0L;

        questionId = question.getQuestionId();
        title = question.getTitle();
        content = question.getContent();
        createdAt = question.getCreatedAt();
        success = question.isSuccess();
        memberId = question.getMemberId();

        String author = null;

        QuestionResponseDto questionResponseDto = new QuestionResponseDto( questionId, title, content, createdAt, success, memberId, author );

        return questionResponseDto;
    }
}
