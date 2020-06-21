package com.drapala.quiz2.testData;

import com.drapala.quiz2.model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class AnswerProvider {

    public static Page<Answer> getPage() {
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setContent("Content 1");
        answer.setCorrect(false);
        return new PageImpl<>(List.of(answer));
    }
}
