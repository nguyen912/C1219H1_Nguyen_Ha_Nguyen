package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findPostsByCategory(Category category);
    Page<Post> findPostsByTitleContaining(String title, Pageable pageable);
}
