package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable);

    Page<Blog> findAllByQuickViewContaining(String quickView, Pageable pageable);

    Page<Blog> findAllByDatePost(Date datePost, Pageable pageable);

    Page<Blog> findAllByOrderByDatePostAsc(Pageable pageable);

    Page<Blog> findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(String nameBlog, String quickView, int min, int max, Pageable pageable);
}
