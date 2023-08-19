package com.preproject_35.question.entity;

import com.preproject_35.answer.entity.Answer;
import com.preproject_35.like.questionlike.entity.QuestionLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(QuestionListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    private long memberId; // 외래키

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean success = true;

    // Question 에서만 Answer 정보 조회할거니까 1:N 단방향 엔티티 매핑
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    // 추가자 : 박성원
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private QuestionLike questionLike;

    /**
     * cascade = CascadeType.ALL : 부모와 자식 엔티티를 한 번에 영속화 + 한번에 제거
     * fetch = FetchType.EAGER : 즉시로딩 , fetch = fetchType.LAZY : 지연로딩
     */

    // 추가자 : 박성원 -> 좋아요 클래스 구현 위함
    public void setQuestionLike(QuestionLike questionLike) {
        this.questionLike = questionLike;
        if (questionLike.getQuestion() != this) {
            questionLike.setQuestion(this);
        }
    }
}
