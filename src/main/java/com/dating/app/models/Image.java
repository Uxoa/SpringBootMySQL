package com.dating.app.models;

public class Image extends Profile {
    private String userId;
    private String imageUrl;
    private boolean isPublic;
    private int displayOrder;
    
    // constructor, getters, setters, etc.
    
    
    public Image(String userId, String imageUrl, boolean isPublic, int displayOrder) {
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.isPublic = isPublic;
        this.displayOrder = displayOrder;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public boolean isPublic() {
        return isPublic;
    }
    
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
    
    public int getDisplayOrder() {
        return displayOrder;
    }
    
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}