package com.testsession.model;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;


    private String password;


    private String username;


    public User() {
        super();
    }
etId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
