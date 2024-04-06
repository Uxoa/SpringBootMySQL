package com.dating.app.controllers;

import com.dating.app.models.User;
import com.dating.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.getUser(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userService.saveUser(user);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/likes/{likeId}")
    public User likeUser(@PathVariable Long id, @PathVariable Long likeId) {
        User user = userService.getUser(id);
        User likedUser = userService.getUser(likeId);
        if (user != null && likedUser != null) {
            userService.likeUser(user, likedUser);
            return user;
        }
        return null;
    }
    
    @PostMapping("/{id}/dislikes/{dislikeId}")
    public User dislikeUser(@PathVariable Long id, @PathVariable Long dislikeId) {
        User user = userService.getUser(id);
        User dislikedUser = userService.getUser(dislikeId);
        if (user != null && dislikedUser != null) {
            userService.dislikeUser(user, dislikedUser);
            return user;
        }
        return null;
    }
    
    @GetMapping("/{id}/potentialMatches")
    public List<User> getPotentialMatches(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return userService.getPotentialMatches(user);
        }
        return null;
    }
    
    @GetMapping("/search")
    public List<User> searchUsersByName(@RequestParam String name) {
        return userService.searchUsersByName(name);
    }
    
    // más endpoints con base en mi UserService...
}