package com.preproject_35.element.like.question_like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions/{question-id}/likes")
public class QuestionLikeController {
    private final QuestionLikeService questionLikeService;

    @Autowired
    public QuestionLikeController(QuestionLikeService questionLikeService) {
        this.questionLikeService = questionLikeService;
    }

    @PostMapping
    public void addLike(@PathVariable("question-id") long questionId, @RequestParam long memberId) {
        questionLikeService.addLike(memberId, questionId);
    }

    @DeleteMapping
    public void removeLike(@PathVariable("question-id") long questionId, @RequestParam long memberId) {
        questionLikeService.removeLike(memberId, questionId);
    }
}
