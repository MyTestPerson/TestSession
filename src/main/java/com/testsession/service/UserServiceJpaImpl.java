package com.testsession.service;

import com.testsession.model.User;
import com.testsession.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceJpaImpl implements UserServiceJpa {


    private final
    UserRepository userRepository;

    public UserServiceJpaImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
