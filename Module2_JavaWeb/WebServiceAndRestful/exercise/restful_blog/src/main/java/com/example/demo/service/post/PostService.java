package com.example.demo.service.post;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(Integer id);

    Post save(Post post);

    void delete(Post post);
}
