package com.drapala.quiz2.service;

import com.drapala.quiz2.Quiz2Application;
import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.repository.QuizRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Quiz2Application.class)
public class QuizServiceImplTest {

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver;

    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    private QuizRepository quizRepository;

    private Page<Quiz> quizPage;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Quiz quiz1 = new Quiz();
        Quiz quiz2 = new Quiz();
        quiz1.setTitle("Quiz 1");
        quiz2.setTitle("Quiz 2");
        quizPage = new PageImpl<>(Arrays.asList(quiz1, quiz2));
    }

    @Test
    public void getTest() {
        when(quizRepository.findAll(any(Pageable.class))).thenReturn(quizPage);
        var result = quizRepository.findAll(Pageable.unpaged());
        assertEquals(quizPage.getTotalElements(), result.getTotalElements());
        assertEquals(quizPage.getContent().get(1), result.getContent().get(1));
    }


}
