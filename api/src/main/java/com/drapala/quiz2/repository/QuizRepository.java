package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
