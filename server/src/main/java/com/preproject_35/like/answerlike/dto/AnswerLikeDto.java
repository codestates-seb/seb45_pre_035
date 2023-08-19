package com.preproject_35.like.answerlike.dto;

import com.preproject_35.like.answerlike.entity.AnswerLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class AnswerLikeDto {
    @Getter
    @AllArgsConstructor
    public static class Post {

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        //좋아요 안좋아요

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{
        private Long memberId;
        private Long likeId;
        private Map<Long, AnswerLike.LikeStatus> likeStatus;
        private int likeCount;

    }
}
