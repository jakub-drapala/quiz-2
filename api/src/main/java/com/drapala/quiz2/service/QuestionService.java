package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Question;

public interface QuestionService {

    Question addQuestion(Question question, Long quizId);
}
