package com.drapala.quiz2.service;

import com.drapala.quiz2.model.AppUser;
import com.drapala.quiz2.repository.UserRepository;
import com.drapala.quiz2.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, AppUserService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser addUser(AppUser appUser) {
        return this.userRepository.save(appUser);
    }

    @Override
    public boolean existsByName(String name) {
        return this.userRepository.existsByUsername(name);
    }

    @Override
    public AppUser getByName(String name) {
        return userRepository.findByUsername(name);
    }
}
