package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.security.SecurityConstants;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
// @RolesAllowed(SecurityConstants.ROLE_ADMIN)
@RequestMapping("questions/")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService questionService) {
        this.service = questionService;
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }
}
