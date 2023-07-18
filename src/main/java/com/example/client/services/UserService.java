package com.example.client.services;

import com.example.client.data.UserDTO;
import com.example.client.entities.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    User saveUser(UserDTO userDTO);
    User saveUser(User user);
    void deleteUser(Long userId);
    UserDTO getUserById(Long userId);

}
