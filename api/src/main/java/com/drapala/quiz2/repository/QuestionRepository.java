package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAllByQuiz_Id(long quizId);
}
