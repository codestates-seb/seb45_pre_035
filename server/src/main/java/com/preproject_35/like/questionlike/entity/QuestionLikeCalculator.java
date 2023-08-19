package com.preproject_35.like.questionlike.entity;

import java.util.Collection;

public class QuestionLikeCalculator {

        // QuestionLike 를 입력받아 Map<> 에 저장된 투표를 합산하는 메서드
        public static int calQuestionVote(QuestionLike questionLike) {
            if (questionLike.getVoteStatus() == null) return 0;

            Collection<QuestionLike.VoteStatus> votes =  questionLike.getVoteStatus().values();

            return votes.stream()
                    .map(voteStatus -> voteStatus.getVoteNumber())
                    .mapToInt(voteNumber -> voteNumber)
                    .sum();
        }
}
