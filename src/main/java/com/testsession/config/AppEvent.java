package com.testsession.config;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

public class AppEvent implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        container.addListener(new HttpSessionEventPublisher());
    }
}
