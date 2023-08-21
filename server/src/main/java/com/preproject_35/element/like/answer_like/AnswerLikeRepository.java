package com.preproject_35.element.like.answer_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerLikeRepository extends JpaRepository<AnswerLike, Long> {
    AnswerLike findByMemberIdAndAnswerId(long memberId, long answerId);
}
