package com.testsession.service;

import com.testsession.model.User;

public interface UserServiceJpa {

    void save(User user);

    User findByUsername(String username);

}
