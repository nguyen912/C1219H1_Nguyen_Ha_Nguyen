package com.example.demo.service.post;

import com.example.demo.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostService {
    PagingAndSortingRepository<Post, Long> findAllPosts();
}
