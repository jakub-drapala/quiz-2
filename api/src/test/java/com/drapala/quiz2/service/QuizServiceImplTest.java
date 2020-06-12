package com.drapala.quiz2.service;

import com.drapala.quiz2.Quiz2Application;
import com.drapala.quiz2.exceptions.ResourceNotFoundException;
import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.testData.QuizProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Quiz2Application.class)
public class QuizServiceImplTest {

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver;

    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    private QuizRepository quizRepository;


    @Test
    public void getTest() {
        Page<Quiz> quizPage = QuizProvider.getPage();
        when(quizRepository.findAll(any(Pageable.class))).thenReturn(quizPage);
        var result = quizRepository.findAll(Pageable.unpaged());
        assertEquals(quizPage.getTotalElements(), result.getTotalElements());
        assertEquals(quizPage.getContent().get(1), result.getContent().get(1));
        verify(quizRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    public void removeExceptionTest() {
        when(quizRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> quizService.remove(1L)).hasMessage(ResourceNotFoundException.QUIZ_NOT_FOUND);
        verify(quizRepository, times(1)).findById(anyLong());
    }

    @Test
    public void removeTest() {
        when(quizRepository.findById(anyLong())).thenReturn(Optional.of(QuizProvider.get()));
        doNothing().when(quizRepository).delete(any(Quiz.class));
        quizService.remove(1L);
        verify(quizRepository, times(1)).findById(anyLong());
        verify(quizRepository, times(1)).delete(any(Quiz.class));
    }

    @Test
    public void updateTitleTest() {
        Quiz quiz = QuizProvider.get();
        String newTitle = "Updated title";
        when(quizRepository.findById(anyLong())).thenReturn(Optional.of(quiz));
        quiz.setTitle(newTitle);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);
        assertEquals(quizService.updateTitle(1L, newTitle).getTitle(), newTitle);
        verify(quizRepository, times(1)).findById(anyLong());
        verify(quizRepository, times(1)).save(any(Quiz.class));
    }

    @Test
    public void updateExceptionTest() {
        when(quizRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> quizService.remove(1L)).hasMessage(ResourceNotFoundException.QUIZ_NOT_FOUND);
        verify(quizRepository, times(1)).findById(anyLong());
    }
}
