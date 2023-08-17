package com.preproject_35.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Answer {
    @Id // PK 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp // 답변 작성 시간
    private LocalDateTime createDate;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id") // FK 참조 컬럼, question 엔티티에도 매핑 필요
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // FK 참조 컬럼, member 엔티티에도 매핑 필요
    private Member member;

*/

}

