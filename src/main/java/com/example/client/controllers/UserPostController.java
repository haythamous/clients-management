package com.example.client.controllers;

import com.example.client.entities.Post;
import com.example.client.entities.User;
import com.example.client.services.PostService;
import com.example.client.services.UserService;
import graphql.GraphQLError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.validation.BindException;

import java.util.List;
import java.util.Optional;


@Controller
public class UserPostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @QueryMapping
    public User getUser(@Argument Long id) {
        Optional<User> userById = userService.getUserById(id);
        return userById.isPresent() ? userById.get(): new User();
    }
    @QueryMapping
    public List<User> getAllUsers() {
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
    @MutationMapping
    public String deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }


}
