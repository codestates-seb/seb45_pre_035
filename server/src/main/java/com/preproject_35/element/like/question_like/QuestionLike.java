package com.preproject_35.element.like.question_like;

import com.preproject_35.element.like.interface_like.Like;

import javax.persistence.*;

@Entity
@Table
public class QuestionLike extends Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long questionId;

    protected QuestionLike() {}

    public QuestionLike(long memberId, long questionId) {
        super(memberId);
        this.questionId = questionId;
    }

    public long getId() {
        return id;
    }

    public long getQuestionId() {
        return questionId;
    }
}
