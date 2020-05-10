package com.example.demo.service.post;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAllPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Post> findPostsByCategory(Category category) {
        return postRepository.findPostsByCategory(category);
    }

    @Override
    public Page<Post> findPostsByTitleContaining(String title, Pageable pageable) {
        return postRepository.findPostsByTitleContaining(title, pageable);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void removePost(Long id) {
        postRepository.deleteById(id);
    }
}
