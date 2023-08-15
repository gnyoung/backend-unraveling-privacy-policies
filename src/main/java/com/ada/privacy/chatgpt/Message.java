package com.ada.privacy.chatgpt;

//Source: https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class Message {
    private String role;
    private String content;

    Message() {

    }

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
