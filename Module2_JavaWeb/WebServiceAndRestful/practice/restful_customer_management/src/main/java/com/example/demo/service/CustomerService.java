package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    void delete(Customer customer);
}
