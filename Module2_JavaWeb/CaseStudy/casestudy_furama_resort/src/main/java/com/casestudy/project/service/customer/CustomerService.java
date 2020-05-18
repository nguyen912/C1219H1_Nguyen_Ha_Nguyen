package com.casestudy.project.service.customer;

import com.casestudy.project.model.customer.Customer;
import com.casestudy.project.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Customer findCustomerById(Integer id);

    void saveCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);

    Page<Customer> findCustomerByAddressContaining(String address, Pageable pageable);

    Page<Customer> findCustomerByNameContainingAndAddressContaining(String name, String address, Pageable pageable);

    Page<Customer> findCustomersByNameContainingAndAddressContainingAndCustomerType(String name, String address, CustomerType customerType, Pageable pageable);
}
