package com.example.demo.service.customer;

import com.example.demo.model.Classify;
import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Customer findCustomerById(Long id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Page<Customer> findCustomersByNameContainingAndProvinceContainingAndClassifyContainingAndBirthdayContaining(
            String name, Province province, Classify classify, String birthday);
}
