package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.repository.AnswerRepository;
import com.drapala.quiz2.service.AnswerService;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    @Override
    public List<Answer> getByQuestionId(Long questionId) {
        var question = questionService.getById(questionId);
        return question.getAnswers();
    }

    @Override
    public List<Answer> add(long quizId, long questionId, Answer answer) {
        var question = questionService.getById(questionId);
        question.addAnswer(answer);
        return questionService.update(question).getAnswers();
    }

    @Override
    public void update(Answer answer) {
        answerRepository.save(answer);
    }
}
