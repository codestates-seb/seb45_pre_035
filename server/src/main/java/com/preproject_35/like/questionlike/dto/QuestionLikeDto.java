package com.preproject_35.like.questionlike.dto;

import com.preproject_35.like.questionlike.entity.QuestionLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class QuestionLikeDto {
    @Getter
    @AllArgsConstructor
    public static class Post {



    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{
        private Long voteId;
        private Map<Long, QuestionLike.VoteStatus> voteStatus;
        private int voteCount;

    }
}
