package com.preproject_35.comment.question.service;

import com.preproject_35.comment.question.entity.QuestionComment;
import com.preproject_35.comment.question.repository.QuestioncommentRepository;
import com.preproject_35.error.BusinessLogicException;
import com.preproject_35.error.ExceptionCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionCommentService {
    private QuestioncommentRepository questioncommentRepository;

    public QuestionCommentService(QuestioncommentRepository questioncommentRepository) {
        this.questioncommentRepository = questioncommentRepository;
    }

    // 댓글 등록
    public QuestionComment createQuestionComment(QuestionComment questionComment) {

        return questioncommentRepository.save(questionComment);
    }

    // 댓글 수정
    public QuestionComment updateQuestionComment(QuestionComment questionComment) {

        QuestionComment findQuestionComment = findVerifiedQuestionComment(questionComment.getQuestionCommentId());

        Optional.ofNullable(questionComment.getContent())
                .ifPresent(content -> findQuestionComment.setContent(content));

        return questioncommentRepository.save(findQuestionComment);

    }

    // 댓글 조회
    public List<QuestionComment> findQuestionComments() {

        return questioncommentRepository.findAll();
    }

    // 댓글 삭제
    public void deleteQuestionComment(long commentId) {
        QuestionComment findQuestionComment = findVerifiedQuestionComment(commentId);

        questioncommentRepository.delete(findQuestionComment);

    }

    // 존재하는 comment 여부 검증
    public QuestionComment findVerifiedQuestionComment(long commentId) {
        Optional<QuestionComment> optionalQuestionComment =
                questioncommentRepository.findById(commentId);
        QuestionComment findQuestionComment =
                optionalQuestionComment.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        return findQuestionComment;
    }
}
