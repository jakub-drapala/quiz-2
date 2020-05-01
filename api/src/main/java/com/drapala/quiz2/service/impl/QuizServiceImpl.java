package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Page<Quiz> get(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }
}
