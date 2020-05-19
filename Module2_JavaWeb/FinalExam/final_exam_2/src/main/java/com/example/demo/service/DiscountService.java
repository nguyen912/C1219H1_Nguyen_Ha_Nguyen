package com.example.demo.service;

import com.example.demo.model.Discount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface DiscountService {
    Iterable<Discount> findAll();

    Discount findById(Long id);

    void save(Discount discount);

    void delete(Discount discount);
}
