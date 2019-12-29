package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
