package com.preproject_35.element.like.answer_like;

import com.preproject_35.element.like.interface_like.Like;

import javax.persistence.*;

@Entity
@Table
public class AnswerLike extends Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long answerId;

    protected AnswerLike() {}

    public AnswerLike(long memberId, long answerId) {
        super(memberId);
        this.answerId = answerId;
    }

    public long getId() {
        return id;
    }

    public long getAnswerId() {
        return answerId;
    }
}
