package com.casestudy.project.service.detail_contract;

import com.casestudy.project.model.contract.DetailContract;
import com.casestudy.project.repository.DetailContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetailContractServiceImpl implements DetailContractService{
    @Autowired
    private DetailContractRepository detailContractRepository;

    @Override
    public Iterable<DetailContract> findAll(Pageable pageable) {
        return detailContractRepository.findAll(pageable);
    }

    @Override
    public DetailContract save(DetailContract detailContract) {
        return detailContractRepository.save(detailContract);
    }
}
