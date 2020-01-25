package com.drapala.quiz2.repository;

import com.drapala.quiz2.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    boolean existsByUsername(String username);
    AppUser findByUsername(String username);
}
