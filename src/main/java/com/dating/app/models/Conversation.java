package com.dating.app.models;

import java.util.List;


public class Conversation {
    private String userId1;
    private String userId2;
    private List<Message> messages;
    
    // constructor, getters, setters, etc.
    
    public Conversation(String userId1, String userId2, List<Message> messages) {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.messages = messages;
    }
    
    public String getUserId1() {
        return userId1;
    }
    
    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }
    
    public String getUserId2() {
        return userId2;
    }
    
    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }
    
    public List<Message> getMessages() {
        return messages;
    }
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    @Override
    public String toString() {
        return "Conversation{" +
              "userId1='" + userId1 + '\'' +
              ", userId2='" + userId2 + '\'' +
              ", messages=" + messages +
              '}';
    }
}