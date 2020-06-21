package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.repository.AnswerRepository;
import com.drapala.quiz2.service.AnswerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Page<Answer> getByQuestionId(Long questionId, Pageable page) {
        return answerRepository.getAllByQuestion_Id(questionId, page);
    }
}
