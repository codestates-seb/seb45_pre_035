package com.preproject_35.element.comment.answerComment.mapper;

import com.preproject_35.answerComment.dto.AnswerCommentPatchDto;
import com.preproject_35.answerComment.dto.AnswerCommentPostDto;
import com.preproject_35.answerComment.dto.AnswerCommentResponseDto;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.comment.answerComment.entitiy.AnswerComment;
<<<<<<< HEAD
import com.preproject_35.element.member.entity.Member;
=======
import com.preproject_35.element.member.Entity.Member;
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerCommentMapper {
    default AnswerComment answerCommentPostDtoToAnswerComment(AnswerCommentPostDto answerCommentPostDto, Member member, Answer answer){
        AnswerComment answerComment = new AnswerComment();
        answerComment.setMember(member);
        answerComment.setAnswer(answer);
        answerComment.setContent(answerCommentPostDto.getContent());
        return answerComment;
    }

    default AnswerComment answerCommentPatchDtoToAnswerComment(AnswerCommentPatchDto answerCommentPatchDto, Member member, Answer answer) {
        AnswerComment answerComment= new AnswerComment();
        answerComment.setAnswerCommentId(answerCommentPatchDto.getAnswerCommentId());
        answerComment.setMember(member);
        answerComment.setAnswer(answer);
        answerComment.setContent(answerCommentPatchDto.getContent());
        return answerComment;
    }

    default AnswerCommentResponseDto answerCommentToAnswerCommentPostResponseDto(AnswerComment answerComment) {
        AnswerCommentResponseDto answerCommentResponseDto = new AnswerCommentResponseDto();
        answerCommentResponseDto.setSuccess(true);
        answerCommentResponseDto.setMessage("댓글이 등록되었습니다.");
        answerCommentResponseDto.setContent(answerComment.getContent());
        answerCommentResponseDto.setCreateAt(answerComment.getCreatedAt());
        answerCommentResponseDto.setAuthor(answerComment.getMember().getUsername());
        answerCommentResponseDto.setMemberId(answerComment.getMember().getMemberId());
        return answerCommentResponseDto;
    }

    default AnswerCommentResponseDto answerCommentToAnswerCommentPatchResponseDto(AnswerComment answerComment) {
        AnswerCommentResponseDto answerCommentResponseDto = new AnswerCommentResponseDto();
        answerCommentResponseDto.setSuccess(true);
        answerCommentResponseDto.setMessage("댓글이 수정되었습니다.");
        answerCommentResponseDto.setAnswerCommentId(answerComment.getAnswerCommentId());
        answerCommentResponseDto.setContent(answerComment.getContent());
        answerCommentResponseDto.setCreateAt(answerComment.getModifiedAt());
        answerCommentResponseDto.setAuthor(answerComment.getMember().getUsername());
        answerCommentResponseDto.setMemberId(answerComment.getMember().getMemberId());
        return answerCommentResponseDto;
    }
}
