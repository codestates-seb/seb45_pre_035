package com.preproject_35.element.answer.entity;


import com.preproject_35.element.comment.answerComment.entitiy.AnswerComment;
import com.preproject_35.element.member.entity.Member;
import com.preproject_35.element.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) // 이벤트 리스너 등록, AuditingEntityListener를 사용해 엔티티 생성시간, 수정시간 구현
public class Answer {
    // 데이터 베이스에 저장될 요소
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;  // 답변 ID

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;    // Question - 질문 ID와 매핑 (질문 1 : 답변 N)

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;  // Member - 멤버 ID와 매핑 (멤버 1 : 답변 N)

    @Column(columnDefinition = "TEXT", nullable = false) // content 필드를 TEXT 타입의 컬럼으로 지정
    private String content; // 답변 내용

    @CreationTimestamp
    private LocalDateTime createdAt;    // 답변 생성 시간

    @LastModifiedDate
    private LocalDateTime modifiedAt;   // 답변 수정 시간

    @OneToMany(mappedBy = "answer") // answer 엔티티의 필드명
    private List<AnswerComment> commentList = new ArrayList<>(); // AnswerComment와 매핑 (댓글 N : 답변 1)

}
