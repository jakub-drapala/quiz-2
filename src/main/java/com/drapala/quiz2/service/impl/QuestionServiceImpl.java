package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuestionRepository;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question addQuestion(Question question) {
        return repository.save(question);
    }
}
