package com.dating.app.services;

import com.dating.app.models.User;
import com.dating.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User saveUser(User user) {
        if (user.getId() == null) {
            return userRepository.save(user);
        } else {
            throw new IllegalStateException("Cannot create user with an already set ID");
        }
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public List<User> getBlockedUsers(User user) {
        return userRepository.findByBlockedsContaining(user);
    }
    
    
    public void likeUser(User user, User likedUser) {
        user.addLikedUser(likedUser);
        userRepository.save(user);
    }
    
    public void blockUser(User user, User blockedUser) {
        user.addBlockedUser(blockedUser);
        userRepository.save(user);
    }
    
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new IllegalArgumentException("Authentication failed");
    }
    
    public void sendMessage(User sender, User receiver, String message) {
        // Add messaging functionality
    }
    
    public List<User> getMatches(User user) {
        return user.getMatches();
    }
    
    public void dislikeUser(User user, User dislikedUser) {
        user.getDislikes().add(dislikedUser);
        userRepository.save(user);
    }
    
    public List<User> getPotentialMatches(User user) {
        List<User> blockeds = user.getBlockeds();
        List<User> likes = user.getLikes();
        List<User> dislikes = user.getDislikes();
        List<User> myBlockeds = user.getMyBlockeds();
        List<User> potentialMatches = userRepository.findAll();
        potentialMatches.removeAll(blockeds);
        potentialMatches.removeAll(likes);
        potentialMatches.removeAll(dislikes);
        potentialMatches.removeAll(myBlockeds);
        potentialMatches.remove(user);
        return potentialMatches;
    }
    
    public List<User> searchUsersByName(String name) {
        return Collections.singletonList(userRepository.findByUsername(name));
    }
}