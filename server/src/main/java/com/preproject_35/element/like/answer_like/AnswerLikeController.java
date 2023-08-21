package com.preproject_35.element.like.answer_like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers/{answer-id}/likes")
public class AnswerLikeController {
        private final AnswerLikeService answerLikeService;

        @Autowired
        public AnswerLikeController(AnswerLikeService answerLikeService) {
            this.answerLikeService = answerLikeService;
        }

        @PostMapping
        public void addLike(@PathVariable("answer-id") long answerId, @RequestParam long memberId) {
            answerLikeService.addLike(memberId, answerId);
        }

        @DeleteMapping
        public void removeLike(@PathVariable("answer-id") long answerId, @RequestParam long memberId) {
            answerLikeService.removeLike(memberId, answerId);
        }
}
