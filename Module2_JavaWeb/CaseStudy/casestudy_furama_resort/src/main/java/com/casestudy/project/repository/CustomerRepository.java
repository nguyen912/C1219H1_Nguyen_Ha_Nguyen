package com.casestudy.project.repository;

import com.casestudy.project.model.customer.Customer;
import com.casestudy.project.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    //search name + address + customerType
    Page<Customer> findCustomersByNameContainingAndAddressContainingAndCustomerType(String name, String address, CustomerType customerType, Pageable pageable);
}
