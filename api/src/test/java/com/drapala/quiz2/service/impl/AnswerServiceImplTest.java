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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
//        List<Answer> answers = AnswerProvider.getAnswers();
//        when(answerRepository.getAllByQuestion_Id(anyLong())).thenReturn(answers);
//        assertEquals(answerService.getByQuestionId(1L), answers);
//        verify(answerRepository, times(1)).getAllByQuestion_Id(anyLong());
    }
}
