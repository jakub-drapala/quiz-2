package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);
    User findByUsername(String username);
}
