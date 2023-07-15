package com.example.client.services;

import com.example.client.entities.Post;
import com.example.client.entities.User;
import com.example.client.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
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