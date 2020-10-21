package com.testsession.service;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiveUserServiceImpl implements ActiveUserService{


    private final
    SessionRegistry sessionRegistry;

    public ActiveUserServiceImpl(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }



}
