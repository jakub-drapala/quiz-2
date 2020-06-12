package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Quiz;
import com.drapala.quiz2.request.SingleValueRequest;
import com.drapala.quiz2.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/quizzes", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public Page<Quiz> get(Pageable pageable) {
        return quizService.get(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        quizService.remove(id);
    }

    @PutMapping("/{id}/title")
    public Quiz updateTitle(@PathVariable Long id, @RequestBody SingleValueRequest<String> title) {
        return quizService.updateTitle(id, title.get());
    }
}
