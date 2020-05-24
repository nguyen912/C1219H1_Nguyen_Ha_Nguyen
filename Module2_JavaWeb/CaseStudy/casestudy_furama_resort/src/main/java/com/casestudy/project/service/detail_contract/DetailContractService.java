package com.casestudy.project.service.detail_contract;

import com.casestudy.project.model.contract.DetailContract;
import org.springframework.data.domain.Pageable;

public interface DetailContractService {
    Iterable<DetailContract> findAll(Pageable pageable);

    DetailContract save(DetailContract detailContract);
}
