package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    Post save(Post post);

    void delete(Post post);

    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByNameContaining(String nameBlog, Pageable pageable);

    Page<Post> findAllByQuickViewContaining(String quickView, Pageable pageable);

    Page<Post> findAllByPostDate(Date datePost, Pageable pageable);

    Page<Post> findAllByOrderByPostDateAsc(Pageable pageable);

    Page<Post> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable);
}
