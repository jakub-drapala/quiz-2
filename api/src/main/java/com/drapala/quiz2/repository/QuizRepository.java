package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("select q.title from Quiz q where q.id = ?1")
    Optional<String> findTileByQuizId(long id);
}
