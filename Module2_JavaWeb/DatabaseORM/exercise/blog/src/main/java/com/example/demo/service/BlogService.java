package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    List<Blog> listAll();
    Blog showById(Integer id);
    void update(Blog blog);
    void remove(Integer id);
}
