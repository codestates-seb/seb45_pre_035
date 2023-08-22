package com.preproject_35.element.answer.repository;

import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

//    // 질문 확인 조회 시, 해당 질문에 대한 답변 리스트
//    // Answer 엔티티 중에서 인자로 받은 question 객체와 같은 question 을 가지는 레코드(행)를 조회
//    @Query(value = "from Answer an where an.question = :question")
//    List<Answer> findByQuestionId(Question question);
//
//    // 마이페이지 답변 조회 시, 내가 남긴 답변 리스트
//    // Answer 엔티티 중에서 인자로 받은 memberId 값과 같은 member_id 값을 가지는 레코드(행)를 조회
//    // 답변 생성일(created_at)을 기준으로 내림차순으로 정렬하며 nativeQuery 속성이 true 이면 해당 쿼리는 SQL 쿼리라는 뜻
//    @Query(value = "SELECT * FROM answer WHERE member_id = :memberId ORDER BY created_at DESC", nativeQuery = true)
//    List<Answer> findByMemberId(long memberId);

}
