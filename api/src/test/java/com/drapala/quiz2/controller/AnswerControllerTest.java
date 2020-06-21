package com.drapala.quiz2.controller;

import com.drapala.quiz2.BaseControllerTest;
import com.drapala.quiz2.service.AnswerService;
import com.drapala.quiz2.testData.AnswerProvider;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AnswerControllerTest extends BaseControllerTest {

    @Mock
    private AnswerService answerService;

    @InjectMocks
    private AnswerController answerController;

    @Override
    protected Object controller() {
        return answerController;
    }

    @Test
    public void getByQuestionIdTest() throws Exception {
        when(answerService.getByQuestionId(anyLong(), any(Pageable.class))).thenReturn(AnswerProvider.getPage());
        api.perform(get("/quizzes/{quizId}/questions/{questionId}/answers", 1L, 2L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", Matchers.is(1)))
                .andExpect(jsonPath("$.content[0].content", Matchers.is("Content 1")));
        Mockito.verify(answerService, times(1)).getByQuestionId(anyLong(), any(Pageable.class));
    }
}
