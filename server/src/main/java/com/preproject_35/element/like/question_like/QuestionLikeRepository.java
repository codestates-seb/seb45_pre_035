package com.preproject_35.element.like.question_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 데이터베이스에서 질문 좋아요에 대한 정보를 조회하거나 저장하는 기능을 제공
@Repository
public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Long> {
    QuestionLike findByMemberIdAndQuestionId(long memberId, long questionId);
    int countByQuestionId(long questionId);
}
