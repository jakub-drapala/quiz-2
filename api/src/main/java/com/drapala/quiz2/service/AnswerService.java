package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getByQuestionId(Long questionId);
}
