package com.preproject_35.element.like.answer_like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerLikeService {
    private final AnswerLikeRepository answerLikeRepository;

    @Autowired
    public AnswerLikeService(AnswerLikeRepository answerLikeRepository) {
        this.answerLikeRepository = answerLikeRepository;
    }

    public void addLike(long memberId, long answerId) {
        AnswerLike answerLike = new AnswerLike(memberId, answerId);
        answerLikeRepository.save(answerLike);
    }

    public void removeLike(long memberId, long answerId) {
        AnswerLike answerLike = answerLikeRepository.findByMemberIdAndAnswerId(memberId, answerId);
        if(answerLike != null) {
            answerLikeRepository.delete(answerLike);
        }
    }
}
