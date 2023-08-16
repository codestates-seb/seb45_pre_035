package com.preproject_35.answer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id // PK 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(columnDefinition = "TEXT") // 컬럼의 속성: 글자 수 제한할 수 없기 때문에 TEXT 사용
    private String content;

    @CreatedDate // 답변 작성 시간
    private LocalDateTime createDate;
/*
    @ManyToOne
    @JoinColumn(name = "question_id") // FK 참조 컬럼, question 엔티티에도 매핑 필요
    private Question question;

    @ManyToOne
    @JoinColumn(name = "member_id") // FK 참조 컬럼, member 엔티티에도 매핑 필요
    private Member member;

*/

}

