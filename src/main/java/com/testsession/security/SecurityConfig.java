package com.testsession.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final
    SessionRegistry sessionRegistry;

    public SecurityConfig(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}1111").roles("ADMIN")
                .and()
                .withUser("roma").password("{noop}1111").roles("ADMIN");
    }


"/").permitAll()
                .mvcMatchers("/login").anonymous()
                .mvcMatchers("/user").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable()
                .logout()
                .permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")

                .and().sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(sessionRegistry)
                .and().sessionFixation().none();

    }


}