package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> get(long id);

    Question addQuestion(Question question, Long quizId);
}
