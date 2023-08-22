package com.preproject_35.element.answer.service;

import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.answer.repository.AnswerRepository;
import com.preproject_35.element.error.BusinessLogicException;
import com.preproject_35.element.error.ExceptionCode;
import com.preproject_35.element.member.Entity.Member;
import com.preproject_35.element.member.Service.MemberService;
import com.preproject_35.element.question.entity.Question;
import com.preproject_35.element.question.repository.QuestionRepository;
import com.preproject_35.element.question.service.QuestionService;
import com.preproject_35.security.auth.userdetails.MemberDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@Transactional
public class AnswerService {

    private final MemberService memberService;
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    // 답변 등록
    public Answer createAnswer(Answer answer, MemberDetailsService.MemberDetails memberDetails, long questionId) {
        Question question = questionService.findVerifiedQuestion(questionId);
        Member member = memberService.findMember(memberDetails.getMemberId());

        answer.setMember(member);
        answer.setQuestion(question);

        return answerRepository.save(answer);
    }

    // 답변 수정
    public Answer updateAnswer(Answer answer, long memberId) {
        // 데이터베이스에 답변 ID 로 답변이 존재 하는지 확인
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        // 해당 질문의 작성자와 memberDetails 작성자가 같은지 확인
        if(findAnswer.getMember().getMemberId() != memberId) {
            throw new BusinessLogicException(ExceptionCode.NOT_AUTHORIZED);
        }
        // 변경 내용이 null 이 아니라면 변경
        Optional.ofNullable(answer.getContent())
                .ifPresent(content -> findAnswer.setContent(content));

        return answerRepository.save(findAnswer);
    }

    // 답변 조회
    public Answer findAnswer(long answerId) {
        return findVerifiedAnswer(answerId);
    }

    // 답변 목록 조회
    public List<Answer> findAnswerByQuestionId(long questionId) {

        Optional<Question> questionOptional = questionRepository.findByQuestionId(questionId);
        if (!questionOptional.isPresent()) {
            // 질문이 없는 경우 예외 처리
            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
        }
        Question question = questionOptional.get();
        return question.getAnswers();
    }


    public void deleteAnswer(long answerId, long memberId) {
        // 데이터베이스에 답변 ID 로 답변이 존재 하는지 확인
        Answer answer = findVerifiedAnswer(answerId);

        // Answer 객체가 속한 Question 객체의 답변들 중 해당 Answer 객체를 삭제
        answer.getQuestion().getAnswers().remove(answer);

        // 답변을 작성한 사람만 삭제 가능
        if(answer.getMember().getMemberId() != memberId) {
            throw new BusinessLogicException(ExceptionCode.NOT_AUTHORIZED);
        }
        answerRepository.delete(answer);
    }


    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        Answer answer = optionalAnswer.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND)
        );
        return answer;
    }
}
