package com.drapala.quiz2.controller;

import com.drapala.quiz2.BaseControllerTest;
import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.service.QuestionService;
import com.drapala.quiz2.testData.QuestionProvider;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest extends BaseControllerTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;

    @Before
    public void init() {
    }

    @Override
    protected Object controller() {
        return questionController;
    }

    @Test
    public void getTest() throws Exception {
        when(questionService.getAll(eq(1L), any(Pageable.class))).thenReturn(QuestionProvider.getPage());
        api.perform(get("/quizzes/{quizId}/questions", 1L).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", Matchers.is(2)))
                .andExpect(jsonPath("$.content[1].content", Matchers.is("Content 2")));
        Mockito.verify(questionService).getAll(anyLong(), any(Pageable.class));
    }

    @Test
    public void addTest() throws Exception {
        Question question = QuestionProvider.get();
        String json = json(question);
        when(questionService.add(any(Question.class), eq(1L))).thenReturn(question);
        api.perform(post("/quizzes/{quizId}/questions", 1L).contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content", Matchers.is("Content 1")));
        Mockito.verify(questionService).add(any(Question.class), eq(1L));

    }
}
