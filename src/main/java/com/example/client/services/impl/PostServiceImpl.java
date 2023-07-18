package com.example.client.services.impl;

import com.example.client.entities.Post;
import com.example.client.repositories.PostRepository;
import com.example.client.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public void deletePost(Long postId) {
        Post post= postRepository.findById(postId).orElseThrow(RuntimeException::new);
        postRepository.delete(post);
    }
}