package com.testsession.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final
    UserDetailsService userDetailsService;


    private final
    SessionRegistry sessionRegistry;

    public SecurityConfig(UserDetailsService userDetailsService, SessionRegistry sessionRegistry) {
        this.userDetailsService = userDetailsService;
        this.sessionRegistry = sessionRegistry;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .mvcMatchers("/").permitAll()
                .mvcMatchers("/login").anonymous()
                .mvcMatchers("/user", "/allUser").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/")

                .and().csrf().disable()

                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")

                .and().sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login")
                .sessionRegistry(sessionRegistry);

    }


}