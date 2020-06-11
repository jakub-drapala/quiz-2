package com.drapala.quiz2.testData;

import com.drapala.quiz2.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class QuizProvider {

    public static Quiz get() {
        Quiz quiz = new Quiz();
        quiz.setId(1L);
        quiz.setTitle("Quiz 1");
        return quiz;
    }

    public static Page<Quiz> getPage() {
        Quiz quiz = get();
        Quiz quiz2 = new Quiz();
        quiz2.setId(2L);
        quiz2.setTitle("Quiz 2");
        return new PageImpl<>(List.of(quiz, quiz2));
    }
}
