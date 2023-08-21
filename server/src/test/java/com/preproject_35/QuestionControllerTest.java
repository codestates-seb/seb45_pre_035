package com.preproject_35;

import com.preproject_35.question.entity.Question;
import com.preproject_35.question.service.QuestionService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @Test
    public void postQuestionTest() throws Exception {
        // Given
        long memberId = 1L;
        String title = "Test Title";
        String content = "Test Content";
        LocalDateTime createdAt = LocalDateTime.now();
        boolean success = true;

        // Mock the required dependencies
        when(questionService.createQuestion(any(Question.class)))
                .thenReturn(new Question(1L, memberId, title, content, createdAt, success));

        // Test data
        String postData = String.format("{\"title\":\"%s\",\"content\":\"%s\"}", title, content);

        // When & Then
        mockMvc.perform(post("/questions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postData))
                .andExpect(status().isCreated());

        verify(questionService).createQuestion(any(Question.class));
    }
}

