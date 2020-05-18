package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByNameContaining(String nameBlog, Pageable pageable);

    Page<Post> findAllByQuickViewContaining(String quickView, Pageable pageable);

    Page<Post> findAllByPostDate(Date datePost, Pageable pageable);

    Page<Post> findAllByOrderByPostDateAsc(Pageable pageable);

    Page<Post> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable);
}
