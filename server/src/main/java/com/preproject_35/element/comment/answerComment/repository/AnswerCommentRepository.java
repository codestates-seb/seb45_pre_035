package com.preproject_35.element.comment.answerComment.repository;

import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.comment.answerComment.entitiy.AnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerCommentRepository extends JpaRepository<AnswerComment, Long> {
    // 답변 확인 조회 시, 해당 답변에 대한 댓글 리스트
    // AnswerComment 엔티티 중에서 인자로 받은 Answer 객체와 같은 answer 을 가지는 레코드(행)를 조회
    @Query(value = "from AnswerComment an where an.answer = :answer")
    List<AnswerComment> findByAnswerId(Answer answer);

    // 마이페이지 댓글 조회 시, 내가 남긴 댓글 리스트
    // AnswerComment 엔티티 중에서 인자로 받은 memberId 값과 같은 member_id 값을 가지는 레코드(행)를 조회
    // 답변 생성일(created_at)을 기준으로 내림차순으로 정렬하며 nativeQuery 속성이 true 이면 해당 쿼리는 SQL 쿼리라는 뜻
    @Query(value = "SELECT * FROM answerComment WHERE member_id = :memberId ORDER BY created_at DESC", nativeQuery = true)
    List<AnswerComment> findByMemberId(long memberId);
}
