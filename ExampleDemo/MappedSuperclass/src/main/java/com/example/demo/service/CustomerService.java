package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    
    Customer save(Customer customer);
    
}
