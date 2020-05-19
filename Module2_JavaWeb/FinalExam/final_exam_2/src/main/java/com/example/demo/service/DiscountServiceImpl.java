package com.example.demo.service;

import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Iterable<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount findById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void delete(Discount discount) {
        discountRepository.delete(discount);
    }
}
