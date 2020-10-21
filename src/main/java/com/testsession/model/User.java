package com.testsession.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
public class User implements Serializable {



    @Column(name = "password", length = 45)
    private String password;



    @Column(name = "username", length = 45)
    private String username;


    public User() {
        super();
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
