package com.casestudy.project.repository;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
}
