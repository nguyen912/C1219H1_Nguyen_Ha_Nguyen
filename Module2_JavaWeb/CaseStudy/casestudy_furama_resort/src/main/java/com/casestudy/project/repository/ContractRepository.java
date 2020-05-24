package com.casestudy.project.repository;

import com.casestudy.project.model.contract.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository extends PagingAndSortingRepository<Contract, Integer> {
}
