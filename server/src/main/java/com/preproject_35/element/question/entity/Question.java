package com.preproject_35.element.question.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.comment.questionComment.question.entity.QuestionComment;
import com.preproject_35.element.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    private long memberId;
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean success = true;

    // Question 에서만 Answer 정보 조회 : 1:N 단방향 엔티티 매핑
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    /**
     * cascade = CascadeType.ALL : 부모와 자식 엔티티를 한 번에 영속화 + 한번에 제거
     * fetch = FetchType.EAGER : 즉시로딩 , fetch = fetchType.LAZY : 지연로딩
     */

    // Question 에서 Member 정보 조회 : N:1 단방향 엔티티 매핑
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // Question 에서 QuestionComment 정보 조회 : 양방향 매핑
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuestionComment> questionComments = new ArrayList<>();
}