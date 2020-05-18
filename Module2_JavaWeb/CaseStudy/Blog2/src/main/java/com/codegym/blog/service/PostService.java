package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void delete(Blog blog);

    Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable);

    Page<Blog> findAllByOrderByDatePostAsc(Pageable pageable);

    Page<Blog> findAllByDatePost(Date datePost, Pageable pageable);

    Page<Blog> findAllByQuickViewContaining(String quickView, Pageable pageable);

    Page<Blog> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable);


}