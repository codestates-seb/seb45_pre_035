package com.preproject_35.like.answerlike.entity;

import com.preproject_35.answer.entity.Answer;
import com.preproject_35.like.questionlike.entity.QuestionLike;
import com.preproject_35.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AnswerLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    // MemberId : "투표상태" 를 HashMap 에 저장
    @ElementCollection
    private Map<Long, LikeStatus> likeStatus = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    private int voteCount;

    // 투표 상태를 enum 타입으로 나타냄.
    public enum LikeStatus {
        VOTE_GOOD(1, "좋아요");

        @Getter
        private int likeNumber;
        @Getter
        private String status;

        LikeStatus(int likeNumber, String status){
            this.likeNumber = likeNumber;
            this.status = status;
        }
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        if(answer.getAnswerLike() != this) {
            answer.setAnswerLike(this);
        }
    }
}