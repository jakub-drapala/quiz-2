package com.drapala.quiz2.testData;

import com.drapala.quiz2.model.Answer;

import java.util.List;

public class AnswerProvider {

    public static List<Answer> getAnswers() {
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setContent("Content 1");
        answer.setCorrect(false);
        return List.of(answer);
    }
}
