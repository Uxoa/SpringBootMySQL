package com.dating.app.models;

public class Message {
    private String text;
    private String timestamp;
    private String senderId;
    
    public Message(String text, String timestamp, String senderId) {
        this.text = text;
        this.timestamp = timestamp;
        this.senderId = senderId;
    }
    
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getSenderId() {
        return senderId;
    }
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    
    
    
}
