package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.security.SecurityConstants;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/quizzes//{quizId}/questions")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @GetMapping
    public List<Question> get(@PathVariable Long quizId) {
        return service.get(quizId);
    }

    @PostMapping
    public Question add(@RequestBody Question question, @PathVariable Long quizId) {
        return service.addQuestion(question, quizId);
    }
}
