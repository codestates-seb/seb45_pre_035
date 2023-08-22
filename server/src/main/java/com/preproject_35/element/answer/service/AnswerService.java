package com.preproject_35.element.answer.service;

import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.repository.AnswerRepository;
import com.preproject_35.element.question.entity.Question;
import com.preproject_35.element.question.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    // 답변 등록
    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    // 답변 수정
    public void updateAnswer(Answer answer) {
        // answer 객체의 answerId를 사용하여 레포지토리에서 저장된 답변(Answer) 정보를 가져옴
        Optional<Answer> optionalAnswer = answerRepository.findById(answer.getAnswerId());
        // 저장된 답변이 있으면, findAnswer 변수에 저장된 답변 객체를 할당하고
        // 저장된 답변이 없다면, "not found answer" 메세지를 가진 RuntimeException을 발생
        Answer findAnswer = optionalAnswer.orElseThrow(() -> new RuntimeException("not found answer"));

        // 저장된 답변의 작성자 이메일(findAnswerEmail)을 가져옴
        String findAnswerEmail = findAnswer.getMember().getEmail();
        // 수정하려는 답변의 작성자 이메일(answerEmail)을 가져옴
        String answerEmail = answer.getMember().getEmail();

        // 두 이메일이 일치할 경우, 저장된 답변의 내용을 수정하려는 답변의 내용으로 변경하고
        // 일치하지 않다면 "403 Forbidden" 메시지를 가진 RuntimeException을 발생시키고 실행을 종료
        if (findAnswerEmail.equals(answerEmail)) {
            findAnswer.setContent(answer.getContent());
        } else new RuntimeException("403 Forbidden");

        answerRepository.save(findAnswer);
    }

    // 특정 답변 조회
    public Answer findAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        return optionalAnswer.orElseThrow(() -> new RuntimeException("not found answer"));
    }

    // 답변 목록 조회 (질문 ID(questionId)를 사용하여 해당하는 답변(Answer) 목록을 조회)
    public List<Answer> findAnswers(long questionId) {
        // // questionId를 이용해 저장소에서 질문을 조회
        Optional<Question> optionalQuestion = questionRepository.findByQuestionId(questionId);

        // 조회된 질문 객체를 얻거나, 객체가 없으면 "not found question" 메시지를 가진 RuntimeException을 발생
        Question findQuestion = optionalQuestion.orElseThrow(() -> new RuntimeException("not found question"));

        // 해당하는 질문에 대한 답변들을 조회
        return answerRepository.findByQuestionId(findQuestion);
    }

    public void deleteAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() -> new RuntimeException("not found answer"));
/*
        // 답변에 달린 댓글
        Iterator comment = findAnswer.getCommentList().iterator();
        while (comment.hasNext()) {
            Comment findComment = (Comment) comment.next();
            commentRepository.delete(findComment);
        }

 */
        answerRepository.deleteById(answerId);
    }
}
