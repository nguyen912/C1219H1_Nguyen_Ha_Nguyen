package com.casestudy.project.service.contract;

import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.customer.Customer;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Iterable<Contract> findAll(Pageable pageable);

    Contract save(Contract contract);

    Iterable<Contract> findByCustomer(Customer customer);
}
