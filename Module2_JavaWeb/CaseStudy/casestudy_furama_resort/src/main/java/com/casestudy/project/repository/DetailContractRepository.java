package com.casestudy.project.repository;

import com.casestudy.project.model.contract.DetailContract;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DetailContractRepository extends PagingAndSortingRepository<DetailContract, Integer> {
}
