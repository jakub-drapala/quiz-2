package com.drapala.quiz2.controller;

import com.drapala.quiz2.model.ClientsQuestion;
import com.drapala.quiz2.response.SingleValueResponse;
import com.drapala.quiz2.service.ClientQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class ClientQuizController {

    private final ClientQuizService clientQuizService;

    @Autowired
    public ClientQuizController(ClientQuizService clientQuizService) {
        this.clientQuizService = clientQuizService;
    }

    @GetMapping("/run")
    public ClientsQuestion run(@RequestParam String quizUid) {
        return clientQuizService.run(quizUid);
    }

    @GetMapping
    public SingleValueResponse welcomeMessage(@RequestParam String quizUid) {
        return SingleValueResponse.of(clientQuizService.getWelcomeMessage(quizUid));
    }
}
