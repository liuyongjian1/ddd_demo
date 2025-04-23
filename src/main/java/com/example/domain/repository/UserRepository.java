package com.example.domain.repository;

import com.example.domain.entity.User;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    void deleteById(Long id);
} 