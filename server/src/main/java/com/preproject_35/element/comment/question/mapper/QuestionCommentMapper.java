package com.preproject_35.element.comment.question.mapper;

import com.preproject_35.element.comment.question.dto.QuestionCommentPatchDto;
import com.preproject_35.element.comment.question.dto.QuestionCommentPostDto;
import com.preproject_35.element.comment.question.dto.QuestionCommentResponseDto;
import com.preproject_35.element.comment.question.entity.QuestionComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionCommentMapper {
    QuestionComment questionCommentPostDtoToQuestionComment(QuestionCommentPostDto questionCommentPostDto);
    QuestionComment questionCommentPatchDtoToQuestionComment(QuestionCommentPatchDto questionCommentPatchDto);
    QuestionCommentResponseDto questionCommentToQuestionCommentResponseDto(QuestionComment questionComment);
}
