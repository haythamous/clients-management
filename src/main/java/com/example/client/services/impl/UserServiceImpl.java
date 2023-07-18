package com.example.client.services.impl;

import com.example.client.data.UserDTO;
import com.example.client.entities.User;
import com.example.client.mappers.UserMapper;
import com.example.client.repositories.UserRepository;
import com.example.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    public User saveUser(UserDTO userDTO) {
        User user = userMapper.dtoToUser(userDTO);
        return userRepository.save(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }

    public UserDTO getUserById(Long userId) {
        User userById = userRepository.findById(userId).orElse(null);
        if (userById != null) {
            return userMapper.userToDto(userById);
        }
        return null;
    }
}
