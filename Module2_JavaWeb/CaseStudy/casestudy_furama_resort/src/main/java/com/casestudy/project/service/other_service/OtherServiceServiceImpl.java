package com.casestudy.project.service.other_service;

import com.casestudy.project.model.service.OtherService;
import com.casestudy.project.repository.OtherServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherServiceServiceImpl implements OtherServiceService{
    @Autowired
    private OtherServiceRepository otherServiceRepository;


    @Override
    public Iterable<OtherService> findAll() {
        return otherServiceRepository.findAll();
    }

    @Override
    public OtherService save(OtherService otherService) {
        return otherServiceRepository.save(otherService);
    }
}
