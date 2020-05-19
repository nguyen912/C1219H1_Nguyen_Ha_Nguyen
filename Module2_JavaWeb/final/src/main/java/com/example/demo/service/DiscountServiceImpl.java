package com.example.demo.service;

import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

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

    @Override
    public Iterable<Discount> findByDiscountPercentAndStartTimeAndAndEndTime(Integer discount, Date startTime, Date endTime) {
        return discountRepository.findByDiscountPercentAndStartTimeAndAndEndTime(discount, startTime, endTime);
    }

    @Override
    public Discount findByDiscountPercent(Integer discount) {
        return discountRepository.findByDiscountPercent(discount);
    }

    @Override
    public Discount findByStartTime(Date start) {
        return discountRepository.findByStartTime(start);
    }

    @Override
    public Discount findByEndTime(Date end) {
        return discountRepository.findByEndTime(end);
    }
}
