package com.example.demo.service.post;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Page<Post> findAllPost(Pageable pageable);

    Post findPostById(Long id);

    Iterable<Post> findPostsByCategory(Category category);

    Page<Post> findPostsByTitleContaining(String title, Pageable pageable);

    void savePost(Post post);

    void removePost(Long id);
}
