package com.testsession.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
                .withUser("user").password("{noop}1111").roles("USER")
                .and()
                .withUser("roma").password("{noop}1111").roles("USER");
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

                .and().sessionManagement().enableSessionUrlRewriting(true)
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1)
                .expiredUrl("/login")
                .sessionRegistry(sessionRegistry)
                .and().sessionFixation().none();

    }


}