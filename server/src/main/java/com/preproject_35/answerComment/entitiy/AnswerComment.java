package com.preproject_35.answerComment.entitiy;

import com.preproject_35.answer.entity.Answer;
import com.preproject_35.member.entity.Member;
import com.preproject_35.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) // 이벤트 리스너 등록, AuditingEntityListener를 사용해 엔티티 생성시간, 수정시간 구현
public class AnswerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerCommentId;

    @ManyToOne
    @JoinColumn(name = "answerId", nullable = false)
    private Answer answer;    // Answer - 답변 ID와 매핑 (답변 1 : 댓글 N)

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;  // Member - 멤버 ID와 매핑 (멤버 1 : 댓글 N)

    @Column(columnDefinition = "TEXT", nullable = false) // content 필드를 TEXT 타입의 컬럼으로 지정
    private String content; // 댓글 내용

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;    // 댓글 생성 시간

    @LastModifiedDate
    @Column(name = "modified_at", nullable = false, updatable = false)
    private LocalDateTime modifiedAt;   // 뎃글 수정 시간

}
