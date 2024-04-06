package com.dating.app.repositories;

import com.dating.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByBlockedsContaining(User user);
    
    User findByUsername(String username);
}