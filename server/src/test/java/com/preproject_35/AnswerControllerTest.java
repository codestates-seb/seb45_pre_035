package com.preproject_35;

import com.preproject_35.answer.entity.Answer;
import com.preproject_35.answer.service.AnswerService;
import com.preproject_35.member.entity.Member;
import com.preproject_35.member.repository.MemberRepository;
import com.preproject_35.question.entity.Question;
import com.preproject_35.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionRepository questionRepository;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private AnswerService answerService;

    public AnswerControllerTest() {
    }

    @Test
    public void postAnswerTest() throws Exception {
        // Given
        long questionId = 1L;
        String email = "test@example.com";
        String content = "This is a test content.";

        // Initialize Question and Member objects
        Question question = new Question();
        question.setQuestionId(questionId);

        Member member = new Member();
        member.setEmail(email);

        // Mock the required dependencies
        when(questionRepository.findByQuestionId(questionId)).thenReturn(Optional.of(question));
        when(memberRepository.findByEmail(email)).thenReturn(Optional.of(member));

        // Test data
        String postData = String.format("{\"email\":\"%s\",\"content\":\"%s\"}", email, content);

        // When & Then
        mockMvc.perform(post("/{questionId}/answers", questionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postData))
                .andExpect(status().isCreated());

        verify(questionRepository).findByQuestionId(questionId);
        verify(memberRepository).findByEmail(email);
        verify(answerService).createAnswer(any(Answer.class));
    }
}



