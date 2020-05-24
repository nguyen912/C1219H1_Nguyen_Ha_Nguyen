package com.casestudy.project.service.contract;

import com.casestudy.project.model.contract.Contract;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Iterable<Contract> findAll(Pageable pageable);

    Contract save(Contract contract);
}
