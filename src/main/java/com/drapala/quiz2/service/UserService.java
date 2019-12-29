package com.drapala.quiz2.service;

import com.drapala.quiz2.model.User;

public interface UserService {

    User addUser(User user);

    boolean existsByName(String name);

    User getByName(String name);
}
