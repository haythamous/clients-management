package com.example.client.controllers;

import com.example.client.entities.Post;
import com.example.client.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
