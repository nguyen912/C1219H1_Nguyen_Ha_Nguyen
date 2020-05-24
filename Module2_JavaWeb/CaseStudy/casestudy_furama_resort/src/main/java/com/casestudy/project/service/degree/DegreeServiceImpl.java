package com.casestudy.project.service.degree;

import com.casestudy.project.model.people.staff.Degree;
import com.casestudy.project.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService{
    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public Iterable<Degree> findAll() {
        return degreeRepository.findAll();
    }
}
