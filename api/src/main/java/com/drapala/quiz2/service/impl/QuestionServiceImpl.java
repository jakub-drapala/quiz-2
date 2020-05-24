package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuestionRepository;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository, QuizRepository quizRepository) {
        this.questionRepository = repository;
        this.quizRepository = quizRepository;
    }

    @Override
    public Page<Question> get(long id, Pageable page) {
        return questionRepository.findAllByQuiz_Id(id, page);
    }

    @Transactional
    @Override
    public Question addQuestion(Question question, Long quizId) {
        var quiz = quizRepository.findById(quizId).orElseThrow(() -> new IllegalStateException("Quiz not found"));
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }
}
