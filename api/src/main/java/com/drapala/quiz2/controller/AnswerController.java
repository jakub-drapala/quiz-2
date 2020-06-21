package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.service.AnswerService;
import com.drapala.quiz2.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizzes/{quizId}/questions/{questionId}")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    Page<Answer> getByQuestionId(@PathVariable Long quizId, @PathVariable Long questionId, Pageable page) {
        return answerService.getByQuestionId(questionId, page);
    }
}
