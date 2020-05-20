package com.casestudy.project.service.customer;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Customer findCustomerById(String id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    }
