package com.example.demo.controller;

import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;

@Controller
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    //Lay danh sach tat ca ca discount
    @GetMapping("/discounts")
    public ModelAndView listDiscounts() {
        Iterable<Discount> discounts = discountService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("discounts", discounts);
        return modelAndView;
    }

    // Den form tao discount
    @GetMapping("/create-discount")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("discount", new Discount());
        return modelAndView;
    }

    //xe ly tao discount
    @PostMapping("/create-discount")
    public ModelAndView saveCustomer(@ModelAttribute("discount") Discount discount){
        discountService.save(discount);

        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("discount", discount);
        modelAndView.addObject("message", "New discount created successfully");
        return modelAndView;
    }

    //Hien thi form xoa, truyen vao id cua doi tuong discount muon xoa
    @GetMapping("/delete-discount/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Discount discount = discountService.findById(id);
        if (discount != null) {
            return new ModelAndView("delete", "discount", discount);
        } else {
            return new ModelAndView("error");
        }
    }

    //thuc hien xoa discount
    @PostMapping("/delete-discount")
    public String deleteBlog(@ModelAttribute("discount") Discount discount) {
        discountService.delete(discount);
        return "redirect:discounts";
    }

    //Tiem kiem bang ba dieu kien: muc giam gia, thoi gian bat dau, thoi gian ket thuc
    @GetMapping("/search-all")
    public ModelAndView search(@RequestParam(name="discount",required = false, defaultValue = "0" )Integer discount,
                               @RequestParam(name="start",required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                               @RequestParam(name = "end", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        Iterable<Discount> discounts;
        discounts = discountService.findByDiscountPercentAndStartTimeAndAndEndTime(discount, start, end);
        ModelAndView modelAndView = new ModelAndView("searchall");
        modelAndView.addObject("discounts", discounts);
        modelAndView.addObject("discount",discount);
        modelAndView.addObject("start",start);
        modelAndView.addObject("end",end);
        return modelAndView;
    }

    //Tim kiem theo tung dieu kien
    @GetMapping("/search")
    public  ModelAndView search(@RequestParam(name = "search") String search, @RequestParam("input") String input) throws ParseException {
        Iterable<Discount> discounts = null;
        Discount discount = null;

        switch (search){
            case "discount": {
                Integer dis = Integer.valueOf(input);
                if(input != null){
                    discount = discountService.findByDiscountPercent(dis);
                } else {
                    discounts = discountService.findAll();
                }
                break;
            }
            case "start": {
                Date date = java.sql.Date.valueOf(input);
                if(input != null){
                    discount = discountService.findByStartTime(date);
                } else {
                    discounts = discountService.findAll();
                }
                break;
            }
            case "end": {
                Date date = java.sql.Date.valueOf(input);
                if(input != null){
                    discount = discountService.findByEndTime(date);
                } else {
                    discounts = discountService.findAll();
                }
                break;
            }
            default:
                discounts = null;
                break;
        }
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("search",search);
        modelAndView.addObject("input",input);
        modelAndView.addObject("discount", discount);
        modelAndView.addObject("discounts", discounts);
        return modelAndView;
    }

}
