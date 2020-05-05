package com.example.demo.service;

import com.example.demo.model.Province;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Integer id);

    void save(Province province);

    void remove(Integer id);
}
