package com.preproject_35.element.like.question_like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 이 서비스 클래스는 질문에 대한 좋아요를 추가, 삭제, 계산하는 기능을 제공
@Service
public class QuestionLikeService {
    private final QuestionLikeRepository questionLikeRepository;

    @Autowired
    public QuestionLikeService(QuestionLikeRepository questionLikeRepository) {
        this.questionLikeRepository = questionLikeRepository;
    }

    public void addLike(long memberId, long questionId) {
        QuestionLike questionLike = new QuestionLike(memberId, questionId);
        questionLikeRepository.save(questionLike);
    }

    public void removeLike(long memberId, long questionId) {
        QuestionLike questionLike = questionLikeRepository.findByMemberIdAndQuestionId(memberId, questionId);
        if (questionLike != null) {
            questionLikeRepository.delete(questionLike);
        }
    }

    public int countLikes(long questionId) {
        return questionLikeRepository.countByQuestionId(questionId);
    }
}
