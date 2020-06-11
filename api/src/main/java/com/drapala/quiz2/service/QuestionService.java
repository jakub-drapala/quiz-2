package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Page<Question> get(long id, Pageable page);

    Question add(Question question, Long quizId);
}
