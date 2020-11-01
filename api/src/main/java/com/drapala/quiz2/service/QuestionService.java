package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Question getById(long id);

    Page<Question> getAll(long id, Pageable page);

    Question add(Question question, Long quizId);

    Question update(Question question);
}
