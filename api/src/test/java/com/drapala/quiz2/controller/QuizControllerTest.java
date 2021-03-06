package com.drapala.quiz2.controller;

import com.drapala.quiz2.BaseControllerTest;
import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.request.SingleValueRequest;
import com.drapala.quiz2.service.QuizService;
import com.drapala.quiz2.testData.QuizProvider;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuizControllerTest extends BaseControllerTest {

    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizService quizService;

    @Override
    protected Object controller() {
        return quizController;
    }

    @Test
    public void getTest() throws Exception {
        when(quizService.get(any(Pageable.class))).thenReturn(QuizProvider.getPage());
        api.perform(get("/quizzes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", Matchers.is(2)))
                .andExpect(jsonPath("$.content[1].title", Matchers.is("Quiz 2")));
        Mockito.verify(quizService, times(1)).get(any(Pageable.class));
    }

    @Test
    public void removeTest() throws Exception {
        doNothing().when(quizService).remove(anyLong());
        api.perform(delete("/quizzes/{id}", 1L))
                .andExpect(status().isNoContent());
        Mockito.verify(quizService, times(1)).remove(anyLong());
    }

    @Test
    public void updateTitleTest() throws Exception {
        Quiz quiz = QuizProvider.get();
        String quizTitle = quiz.getTitle();
        jsonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = json(SingleValueRequest.of(quizTitle));
        when(quizService.updateTitle(anyLong(), any(String.class))).thenReturn(quiz);
        api.perform(put("/quizzes/{id}/title", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is(quiz.getTitle())));
        Mockito.verify(quizService, times(1)).updateTitle(anyLong(), any(String.class));
    }
}
