package com.example.demo.controller;

import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiscountController {
    //Tien doi tuong discountService de su dung cac ham cua chung
    @Autowired
    private DiscountService discountService;

    //List danh sach khuyen mai
    @GetMapping("discounts")
    public ModelAndView listDiscounts() {
        Iterable<Discount> discounts = discountService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("discounts", discounts);
        return modelAndView;
    }
}
