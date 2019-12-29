package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.User;
import com.drapala.quiz2.repository.UserRepository;
import com.drapala.quiz2.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByUsername(name);
    }

    @Override
    public User getByName(String name) {
        return repository.findByUsername(name);
    }
}
