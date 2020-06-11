package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @GetMapping("/{quizId}/questions")
    public Page<Question> get(@PathVariable Long quizId, @PageableDefault Pageable page) {
        return service.get(quizId, page);
    }

    @PostMapping("/{quizId}/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public Question add(@RequestBody Question question, @PathVariable Long quizId) {
        return service.add(question, quizId);
    }
}
