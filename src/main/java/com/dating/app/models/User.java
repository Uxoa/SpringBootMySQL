package com.dating.app.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Image> images;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Location> locations;
    
    @ManyToMany
    @JoinTable(
          name = "user_conversations",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "conversation_id")
    )
    private Set<Conversation> conversations;
    
    private List<User> matches;
    private List<User> myBlockeds;
    private List<User> blockeds = new ArrayList<>();
    private List<User> likes;
    private List<User> dislikes;
    private List<User> likedUsers = new ArrayList<>();
    
    public User() {}
    
    public User(Long id, String name, String email, Profile profile, List<User> matches, List<User> myBlockeds, List<User> blockeds, List<User> likes, List<User> dislikes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.matches = matches;
        this.myBlockeds = myBlockeds;
        this.blockeds = blockeds;
        this.likes = likes;
        this.dislikes = dislikes;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Profile getProfile() {
        return profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    public List<User> getMatches() {
        return matches;
    }
    
    public void setMatches(List<User> matches) {
        this.matches = matches;
    }
    
    public List<User> getMyBlockeds() {
        return myBlockeds;
    }
    
    public void setMyBlockeds(List<User> myBlockeds) {
        this.myBlockeds = myBlockeds;
    }
    
    public void addBlockedUser(User user) {
        this.blockeds.add(user);
    }
    
    public List<User> getBlockeds() {
        return blockeds;
    }
    
    public void setBlockeds(List<User> blockeds) {
        this.blockeds = blockeds;
    }
    
    public List<User> getLikes() {
        return likes;
    }
    
    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
    
    public void addLikedUser(User user) {
        this.likedUsers.add(user);
    }
    
    public List<User> getDislikes() {
        return dislikes;
    }
    
    public void setDislikes(List<User> dislikes) {
        this.dislikes = dislikes;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getName().equals(user.getName()) && getEmail().equals(user.getEmail()) && getProfile().equals(user.getProfile()) && getMatches().equals(user.getMatches()) && getMyBlockeds().equals(user.getMyBlockeds()) && getBlockeds().equals(user.getBlockeds()) && getLikes().equals(user.getLikes()) && getDislikes().equals(user.getDislikes());
    }
    
    public int hashCode() {
        return getId().hashCode() + getName().hashCode() + getEmail().hashCode() + getProfile().hashCode() + getMatches().hashCode() + getMyBlockeds().hashCode() + getBlockeds().hashCode() + getLikes().hashCode() + getDislikes().hashCode();
    }
}