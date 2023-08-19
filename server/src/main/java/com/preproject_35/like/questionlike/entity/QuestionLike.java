package com.preproject_35.like.questionlike.entity;

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
public class QuestionLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    // MemberId : "투표상태" 를 HashMap 에 저장
    @ElementCollection
    private Map<Long, VoteStatus> voteStatus = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    private int voteCount;

    // 투표 상태를 enum 타입으로 나타냄.
    public enum VoteStatus {
        VOTE_GOOD(1, "추천");

        @Getter
        private int voteNumber;
        @Getter
        private String status;

        VoteStatus(int voteNumber, String status){
            this.voteNumber = voteNumber;
            this.status = status;
        }
    }

    public void setQuestion(Question question) {
        this.question = question;
        if(question.getQuestionLike() != this) {
            question.setQuestionLike(this);
        }
    }
}
