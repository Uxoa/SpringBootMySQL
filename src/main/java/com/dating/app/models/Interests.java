package com.dating.app.models;

import java.util.Objects;

public class Interests {
    
    private String interestId;
    private String interestName;
    
    public Interests() {
    }
    
    public Interests(String interestId, String interestName) {
        this.interestId = interestId;
        this.interestName = interestName;
    }
    
    public String getInterestId() {
        return interestId;
    }
    
    public void setInterestId(String interestId) {
        this.interestId = interestId;
    }
    
    public String getInterestName() {
        return interestName;
    }
    
    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interests)) return false;
        Interests interests = (Interests) o;
        return Objects.equals(interestId, interests.interestId) && Objects.equals(interestName, interests.interestName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(interestId, interestName);
    }
}