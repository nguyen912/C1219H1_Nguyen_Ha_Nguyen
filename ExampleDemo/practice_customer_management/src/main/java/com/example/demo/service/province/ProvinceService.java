package com.example.demo.service.province;

import com.example.demo.model.Province;

public interface ProvinceService {
    Iterable<Province> findAllProvince();

    Province findProvinceById(Long id);

    void saveProvince(Province province);

    void deleteProvince(Long id);
}
