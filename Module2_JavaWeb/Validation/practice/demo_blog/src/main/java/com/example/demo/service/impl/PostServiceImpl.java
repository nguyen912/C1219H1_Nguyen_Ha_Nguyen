package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }

    @Override
    public Page<Post> findAllByNameContaining(String nameBlog, Pageable pageable) {
        return postRepository.findAllByNameContaining(nameBlog, pageable);
    }

    @Override
    public Page<Post> findAllByQuickViewContaining(String quickView, Pageable pageable) {
        return postRepository.findAllByQuickViewContaining(quickView, pageable);
    }

    @Override
    public Page<Post> findAllByPostDate(Date datePost, Pageable pageable) {
        return postRepository.findAllByPostDate(datePost, pageable);
    }

    @Override
    public Page<Post> findAllByOrderByPostDateAsc(Pageable pageable) {
        return postRepository.findAllByOrderByPostDateAsc(pageable);
    }

    @Override
    public Page<Post> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable) {
        return postRepository.findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(nameBlog, quickView, min, max, pageable);
    }
}
