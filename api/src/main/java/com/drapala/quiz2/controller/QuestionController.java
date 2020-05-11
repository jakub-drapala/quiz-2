package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.security.SecurityConstants;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/quizzes")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @PostMapping("/{quizId}")
    public Question addQuestion(@RequestBody Question question, @PathVariable Long quizId) {
        return service.addQuestion(question, quizId);
    }
}
