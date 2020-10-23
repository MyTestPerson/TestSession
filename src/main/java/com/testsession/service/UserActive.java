package com.testsession.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@Component
public class UserActive implements HttpSessionBindingListener {

    Logger logger = LoggerFactory.getLogger(UserActive.class);

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        logger.error("Log in : {}", event.getName() );
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logger.error("Log out : {}", event.getName() );
    }

}
