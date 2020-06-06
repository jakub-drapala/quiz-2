package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Question;
import com.drapala.quiz2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

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
        return service.addQuestion(question, quizId);
    }

    @GetMapping("/hello")
    public String hello() {
        return service.hello();
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello) {
        return hello;
    }

    private static class Hello {
        private String title;
        private String value;

        public Hello() {
        }

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
