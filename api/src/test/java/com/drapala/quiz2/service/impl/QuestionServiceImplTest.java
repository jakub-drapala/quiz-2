package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.Quiz2Application;
import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuestionRepository;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.testData.QuestionProvider;
import com.drapala.quiz2.testData.QuizProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.drapala.quiz2.exceptions.ResourceNotFoundException.QUIZ_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Quiz2Application.class)
public class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuizRepository quizRepository;

    @Test
    public void getTest() {
        Page<Question> questionPage = QuestionProvider.getPage();
        when(questionRepository.findAllByQuiz_Id(anyLong(), any(Pageable.class))).thenReturn(questionPage);
        questionService.getAll(1L, Pageable.unpaged());
        verify(questionRepository, times(1)).findAllByQuiz_Id(anyLong(), any(Pageable.class));
    }

    @Test
    public void addExceptionTest() {
        Question question = QuestionProvider.get();
        when(quizRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> questionService.add(question, 1L)).hasMessage(QUIZ_NOT_FOUND);
        verify(quizRepository, times(1)).findById(anyLong());
    }

    @Test
    public void addTest() {
        Question question = QuestionProvider.get();
        when(quizRepository.findById(anyLong())).thenReturn(Optional.of(QuizProvider.get()));
        when(questionRepository.save(question)).thenReturn(question);
        assertEquals(questionService.add(question, 1L).getContent(), QuestionProvider.get().getContent());
        verify(quizRepository, times(1)).findById(anyLong());
        verify(questionRepository, times(1)).save(question);
    }
}
