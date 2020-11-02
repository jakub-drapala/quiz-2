package com.drapala.quiz2.service;

import com.drapala.quiz2.model.ClientsQuestion;

public interface ClientQuizService {


    String getWelcomeMessage(String quizUid);

    ClientsQuestion run(String quizUid);
}
