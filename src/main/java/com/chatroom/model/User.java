package com.chatroom.model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;

    public User(String username) {
        this.username = username;
    }

    // getter方法
    public String getUsername() {
        return username;
    }

    // setter方法
    public void setUsername(String username) {
        this.username = username;
    }
}