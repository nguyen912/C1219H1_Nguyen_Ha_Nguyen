package com.example.demo.repository;

import com.example.demo.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Iterable<Discount> findByDiscountPercentAndStartTimeAndAndEndTime(Integer discount, Date startTime, Date endTime);

    Discount findByDiscountPercent(Integer discount);

    Discount findByStartTime(Date start);

    Discount findByEndTime(Date end);

}
