package com.example.client.controllers;

import com.example.client.data.UserDTO;
import com.example.client.entities.Post;
import com.example.client.entities.User;
import com.example.client.services.PostService;
import com.example.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Controller
public class UserPostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @QueryMapping
    public UserDTO getUser(@Argument Long id) {
        return userService.getUserById(id);
    }
    @QueryMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Post getPost(@Argument Long id) {
        Optional<Post> postById = postService.getPostById(id);
        return postById.isPresent() ? postById.get(): new Post();
    }
    @QueryMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @MutationMapping
    public User createUser(@Argument String name) {
        User user = new User(name);
        return userService.saveUser(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDto) {
        User savedUser = userService.saveUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @MutationMapping
    public String deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }


}
