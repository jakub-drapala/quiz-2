package com.drapala.quiz2.service;

import com.drapala.quiz2.model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnswerService {

    Page<Answer> getByQuestionId(Long questionId, Pageable page);
}
