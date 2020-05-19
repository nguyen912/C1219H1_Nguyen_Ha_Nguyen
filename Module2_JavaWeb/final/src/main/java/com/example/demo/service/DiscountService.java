package com.example.demo.service;

import com.example.demo.model.Discount;

import java.util.Date;

public interface DiscountService {
    Iterable<Discount> findAll();

    Discount findById(Long id);

    void save(Discount discount);

    void delete(Discount discount);

    Iterable<Discount> findByDiscountPercentAndStartTimeAndAndEndTime(Integer discount, Date startTime, Date endTime);

    Discount findByDiscountPercent(Integer discount);

    Discount findByStartTime(Date start);

    Discount findByEndTime(Date end);
}
