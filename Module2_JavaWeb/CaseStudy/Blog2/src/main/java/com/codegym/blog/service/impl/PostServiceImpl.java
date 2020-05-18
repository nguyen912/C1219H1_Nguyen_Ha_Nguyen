package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable) {
        return blogRepository.findAllByNameBlogContaining(nameBlog, pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByDatePostAsc(Pageable pageable){
        return blogRepository.findAllByOrderByDatePostAsc(pageable);
    }

    @Override
     public Page<Blog> findAllByDatePost(Date datePost, Pageable pageable){
        return blogRepository.findAllByDatePost(datePost, pageable);
    }

    @Override
    public Page<Blog> findAllByQuickViewContaining(String quickView, Pageable pageable){
        return blogRepository.findAllByQuickViewContaining(quickView, pageable);
    }

    @Override
    public Page<Blog> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable){
        return blogRepository.findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(nameBlog, quickView, min, max, pageable);
    }





}

