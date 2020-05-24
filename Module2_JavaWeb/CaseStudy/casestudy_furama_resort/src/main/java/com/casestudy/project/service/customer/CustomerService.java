package com.casestudy.project.service.customer;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Customer findCustomerById(String id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByBirthday(Date birthday, Pageable pageable);

    Page<Customer> findByPhoneNumberContaining(String phoneNumber, Pageable pageable);

    Page<Customer> findByCustomerType(CustomerType customerType, Pageable pageable);

    Page<Customer> findByNameContainingAndBirthdayAndCustomerType(String name, Date birthday, CustomerType customerType, Pageable pageable);

    }
