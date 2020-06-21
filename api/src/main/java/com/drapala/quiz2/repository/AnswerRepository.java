package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Page<Answer> getAllByQuestion_Id(Long questionId, Pageable page);

}
