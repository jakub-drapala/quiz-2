package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizzes/{quizId}/questions/{questionId}")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    List<Answer> getByQuestionId(@PathVariable Long quizId, @PathVariable Long questionId) {
        return answerService.getByQuestionId(questionId);
    }
}
