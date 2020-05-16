package com.example.demo.service.province;

import com.example.demo.model.Province;
import com.example.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAllProvince() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }
}
