package com.preproject_35.element.comment.questionComment.question.mapper;


import com.preproject_35.element.comment.questionComment.question.dto.QuestionCommentPatchDto;
import com.preproject_35.element.comment.questionComment.question.dto.QuestionCommentPostDto;
import com.preproject_35.element.comment.questionComment.question.dto.QuestionCommentResponseDto;
import com.preproject_35.element.comment.questionComment.question.entity.QuestionComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionCommentMapper {
    QuestionComment questionCommentPostDtoToQuestionComment(QuestionCommentPostDto questionCommentPostDto);
    QuestionComment questionCommentPatchDtoToQuestionComment(QuestionCommentPatchDto questionCommentPatchDto);
    QuestionCommentResponseDto questionCommentToQuestionCommentResponseDto(QuestionComment questionComment);
}
