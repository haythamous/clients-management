package com.example.client.services;

import com.example.client.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    void savePost(Post post);
    Optional<Post> getPostById(Long postId);
    void deletePost(Long postId);
}
