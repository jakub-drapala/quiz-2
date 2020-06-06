package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

    private ObjectMapper jsonMapper = new ObjectMapper();

    private PageableHandlerMethodArgumentResolver pageableArgumentResolver = new PageableHandlerMethodArgumentResolver();

    private MockMvc api;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    QuestionController questionController;


    private String json(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }

    @Before
    public void init() {
        api = MockMvcBuilders.standaloneSetup(questionController)
                .setCustomArgumentResolvers(new HandlerMethodArgumentResolver[]{pageableArgumentResolver})
                .build();
    }

    @Test
    public void getTest() throws Exception {
        Question question = new Question();
        question.setId(1L);
        question.setContent("Content 1");
        Page<Question> page = new PageImpl<>(List.of(question));

        when(questionService.get(eq(1L), any(Pageable.class))).thenReturn(page);

        api.perform(get("/quizzes/{quizId}/questions", 1L).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(questionService).get(anyLong(), any(Pageable.class));
    }

    @Test
    public void addTest() throws Exception {
        Question question = new Question();
        question.setId(1L);
        question.setContent("Content 1");

        String json = json(question);

        when(questionService.addQuestion(any(Question.class), eq(1L))).thenReturn(question);
        api.perform(post("/quizzes/{quizId}/questions", 1L).contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content", Matchers.is("Content 1")));
        Mockito.verify(questionService).addQuestion(any(Question.class), eq(1L));

    }
}
