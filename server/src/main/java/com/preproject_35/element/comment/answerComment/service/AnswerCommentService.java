package com.preproject_35.answerComment.service;

import com.preproject_35.answer.entity.Answer;
import com.preproject_35.answer.repository.AnswerRepository;
import com.preproject_35.answerComment.entitiy.AnswerComment;
import com.preproject_35.answerComment.repository.AnswerCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final AnswerRepository answerRepository;

    public AnswerCommentService(AnswerCommentRepository answerCommentRepository, AnswerRepository answerRepository) {
        this.answerCommentRepository = answerCommentRepository;
        this.answerRepository = answerRepository;
    }

    // 댓글 등록
    public void createAnswerComment(AnswerComment answerComment) {
        answerCommentRepository.save(answerComment);
    }

    // 댓글 수정
    public void updateAnswerComment(AnswerComment answerComment) {
        Optional<AnswerComment> optionalAnswerComment = answerCommentRepository.findById(answerComment.getAnswerCommentId());
        AnswerComment findAnswerComment = optionalAnswerComment.orElseThrow(()-> new RuntimeException("not found answerComment"));

        String findAnswerCommentEmail = findAnswerComment.getMember().getEmail();
        String AnswerCommentEmail = answerComment.getMember().getEmail();

        if (findAnswerCommentEmail.equals(answerComment)) {
            findAnswerComment.setContent(answerComment.getContent());
        }   else new RuntimeException("401 Unauthorized");

        answerCommentRepository.save(findAnswerComment);
    }

    // 댓글 삭제
    public void deleteAnswerComment(long answerId, long answerCommentId) {
        Optional<AnswerComment> optionalAnswerComment = answerCommentRepository.findById(answerCommentId);
        AnswerComment findAnswerComment = optionalAnswerComment.orElseThrow(() -> new RuntimeException("not found answerComment"));

        if (answerId == findAnswerComment.getAnswer().getAnswerId()) {
            answerCommentRepository.deleteById(answerCommentId);
        }   else new RuntimeException("403 Forbidden");
    }

    // 댓글 목록 조회
    public List<AnswerComment> findComments(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() -> new RuntimeException("not found answer"));

        return answerCommentRepository.findByAnswerId(findAnswer);
    }
}
