package com.casestudy.project.repository;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.stream.Stream;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByBirthday(Date birthday, Pageable pageable);

    Page<Customer> findByPhoneNumberContaining(String phoneNumber, Pageable pageable);

    Page<Customer> findByCustomerType(CustomerType customerType, Pageable pageable);

    Page<Customer> findByNameContainingAndBirthdayAndCustomerType(String name, Date birthday, CustomerType customerType, Pageable pageable);
}
