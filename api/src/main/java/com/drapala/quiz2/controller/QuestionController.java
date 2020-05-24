package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes/{quizId}/questions")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @GetMapping
    public Page<Question> get(@PathVariable Long quizId, Pageable page) {
        return service.get(quizId, page);
    }

    @PostMapping
    public Question add(@RequestBody Question question, @PathVariable Long quizId) {
        return service.addQuestion(question, quizId);
    }
}
