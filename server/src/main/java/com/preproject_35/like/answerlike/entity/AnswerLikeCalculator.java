package com.preproject_35.like.answerlike.entity;

import com.preproject_35.like.questionlike.entity.QuestionLike;

import java.util.Collection;

public class AnswerLikeCalculator {
    // AnswerLike 를 입력받아 Map<> 에 저장된 투표를 합산하는 메서드
    public static int calAnswerLike(AnswerLike answerLike) {
        if (answerLike.getLikeStatus() == null) return 0;

        Collection<AnswerLike.LikeStatus> votes =  answerLike.getLikeStatus().values();

        return votes.stream()
                .map(likeStatus -> likeStatus.getLikeNumber())
                .mapToInt(likeNumber -> likeNumber)
                .sum();
    }
}
