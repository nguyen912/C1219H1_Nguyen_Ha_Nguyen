package com.casestudy.project.service.contract;

import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Iterable<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Iterable<Contract> findByCustomer(Customer customer) {
        return contractRepository.findByCustomer(customer);
    }
}
