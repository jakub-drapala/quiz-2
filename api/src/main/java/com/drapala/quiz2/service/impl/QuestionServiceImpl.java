package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.exceptions.ResourceNotFoundException;
import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuestionRepository;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.drapala.quiz2.exceptions.ResourceNotFoundException.QUIZ_NOT_FOUND;

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
    public Question getById(long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<Question> getAll(long id, Pageable page) {
        return questionRepository.findAllByQuiz_Id(id, page);
    }

    @Transactional
    @Override
    public Question add(Question question, Long quizId) {
        var quiz = quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException(QUIZ_NOT_FOUND));
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }
}
