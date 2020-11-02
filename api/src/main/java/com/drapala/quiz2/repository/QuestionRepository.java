package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    Page<Question> findAllByQuiz_Id(long quizId, Pageable page);

    @Query("select q.id from questions q where q.quiz.id = ?1")
    List<Long> findAllIdByQuizId(long quizId);
}
