package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService{
    Iterable<Customer> findAll();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);
}
