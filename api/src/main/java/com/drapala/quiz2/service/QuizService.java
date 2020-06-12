package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService {

    Page<Quiz> get(Pageable pageable);

    void remove(Long id);

    Quiz updateTitle(Long quizId, String newTitle);
}
