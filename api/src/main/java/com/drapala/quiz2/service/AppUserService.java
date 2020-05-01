package com.drapala.quiz2.service;

import com.drapala.quiz2.model.AppUser;

public interface AppUserService {

    AppUser addUser(AppUser appUser);

    boolean existsByName(String name);

    AppUser getByName(String name);
}
