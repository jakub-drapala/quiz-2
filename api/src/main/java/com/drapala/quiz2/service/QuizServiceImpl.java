package com.drapala.quiz2.service;

import com.drapala.quiz2.exceptions.ResourceNotFoundException;
import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.drapala.quiz2.exceptions.ResourceNotFoundException.QUIZ_NOT_FOUND;

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

    @Override
    public void remove(Long id) {
        var quiz = quizRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(QUIZ_NOT_FOUND));
        quizRepository.delete(quiz);
    }
}
