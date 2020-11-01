package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.Answer;
import com.drapala.quiz2.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Answer> getByQuestionId(@PathVariable Long quizId, @PathVariable Long questionId) {
        return answerService.getByQuestionId(questionId);
    }

    @PostMapping("/answers")
    public List<Answer> add(@PathVariable Long quizId, @PathVariable Long questionId, @RequestBody Answer answer) {
        return answerService.add(quizId, questionId, answer);
    }

    @PutMapping("/answers/{answerId}")
    public void update(@PathVariable Long answerId, @RequestBody Answer answer) {
        answerService.update(answer);
    }
}
