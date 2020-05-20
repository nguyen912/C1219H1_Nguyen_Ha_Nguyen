package com.casestudy.project.service.rent_type;

import com.casestudy.project.model.service.RentType;
import com.casestudy.project.repository.RentTypeRepository;
import com.casestudy.project.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;


    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RentType save(RentType rentType) {
        return rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(RentType rentType) {
        rentTypeRepository.delete(rentType);
    }
}
