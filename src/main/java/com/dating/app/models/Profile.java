package com.dating.app.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String displayName;
    private LocalDate birthDate;
    private String gender;
    private String bio;
    
    @OneToOne(mappedBy = "profile")
    private User user;
    
    private String profileImage;
    
    public Profile() {
    }
    
    public Profile(String displayName, LocalDate birthDate, String gender, String bio, User user, String profileImage) {
        this.displayName = displayName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.bio = bio;
        this.user = user;
        this.profileImage = profileImage;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getProfileImage() {
        return profileImage;
    }
    
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return displayName.equals(profile.displayName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(displayName);
    }
    
    @Override
    public String toString() {
        return "Profile{" +
              "displayName='" + displayName + '\'' +
              ", birthDate=" + birthDate +
              ", gender='" + gender + '\'' +
              ", bio='" + bio + '\'' +
              ", profileImage='" + profileImage + '\'' +
              '}';
    }
}