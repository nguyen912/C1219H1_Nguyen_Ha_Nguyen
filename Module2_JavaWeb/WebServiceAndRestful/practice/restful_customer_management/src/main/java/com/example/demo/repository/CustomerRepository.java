package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {
}
