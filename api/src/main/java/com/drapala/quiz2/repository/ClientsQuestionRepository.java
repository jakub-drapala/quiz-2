package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.ClientsQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsQuestionRepository extends JpaRepository<ClientsQuestion, Long> {
}
