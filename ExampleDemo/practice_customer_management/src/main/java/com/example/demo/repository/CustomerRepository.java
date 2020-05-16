package com.example.demo.repository;

import com.example.demo.model.Classify;
import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findCustomersByNameContainingAndProvinceContainingAndClassifyContainingAndBirthdayContaining(
            String name, Province province, Classify classify, String birthday);

}
