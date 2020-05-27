package com.casestudy.project.repository;

import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository extends PagingAndSortingRepository<Contract, Integer> {
    Iterable<Contract> findByCustomer(Customer customer);
}
