package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<User> findAllUser();
    User findById(Long id);
    void saveUser(User user);
    void removeUser(Long id);
}
