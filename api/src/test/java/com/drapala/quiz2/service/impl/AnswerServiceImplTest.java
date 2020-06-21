package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.Quiz2Application;
import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.repository.AnswerRepository;
import com.drapala.quiz2.testData.AnswerProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Quiz2Application.class)
public class AnswerServiceImplTest {

    @InjectMocks
    private AnswerServiceImpl answerService;

    @Mock
    private AnswerRepository answerRepository;

    @Test
    public void getByQuestionIdTest() {
        Page<Answer> answers = AnswerProvider.getPage();
        when(answerRepository.getAllByQuestion_Id(anyLong(), any(Pageable.class))).thenReturn(answers);
        assertEquals(answerService.getByQuestionId(1L, Pageable.unpaged()), answers);
        verify(answerRepository, times(1)).getAllByQuestion_Id(anyLong(), any(Pageable.class));
    }
}
