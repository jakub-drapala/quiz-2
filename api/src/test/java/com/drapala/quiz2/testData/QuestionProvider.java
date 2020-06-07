package com.drapala.quiz2.testData;

import com.drapala.quiz2.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class QuestionProvider {

    public static Question get() {
        Question question = new Question();
        question.setId(1L);
        question.setContent("Content 1");
        return question;
    }

    public static Page<Question> getPage() {
        Question question = get();
        Question question2 = new Question();
        question2.setId(2L);
        question2.setContent("Content 2");
        return new PageImpl<>(List.of(question, question2));
    }

}
