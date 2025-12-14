package com.chatroom.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String username;
    private String content;
    private LocalDateTime timestamp;

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    // 添加getter方法
    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // 可选：添加setter方法
    public void setUsername(String username) {
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}