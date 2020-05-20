package com.casestudy.project.service.rent_type;

import com.casestudy.project.model.service.RentType;
import com.casestudy.project.model.service.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();

    RentType findById(Integer id);

    RentType save(RentType rentType);

    void delete(RentType rentType);
}
