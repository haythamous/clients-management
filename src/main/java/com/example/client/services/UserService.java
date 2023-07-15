package com.example.client.services;

import com.example.client.entities.User;
import com.example.client.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
