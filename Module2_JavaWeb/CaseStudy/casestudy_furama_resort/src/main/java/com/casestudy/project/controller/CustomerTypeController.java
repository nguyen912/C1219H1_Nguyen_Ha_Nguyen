package com.casestudy.project.controller;

import com.casestudy.project.model.customer.CustomerType;
import com.casestudy.project.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("customer-type")
    public ModelAndView listCustomerType() {
        ModelAndView modelAndView = new ModelAndView("customer_type/list");
        Iterable<CustomerType> customerTypes = customerTypeService.findAllCustomerType();
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

    // Create customer type
    @GetMapping("create-customer-type")
    public ModelAndView createCustomerTypeForm() {
        CustomerType customerType = new CustomerType();
        ModelAndView modelAndView = new ModelAndView("customer_type/create");
        modelAndView.addObject("customerType", customerType);
        return modelAndView;
    }

    @PostMapping("create-customer-type")
    public ModelAndView createCustomerTypeProcess(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.saveCustomerType(customerType);
        ModelAndView modelAndView = new ModelAndView("customer_type/create");
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("message", "The customer type was created successfully!");
        return modelAndView;
    }

    //Edit customer type
    @GetMapping("update-customer-type/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id) {
        CustomerType customerType = customerTypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer_type/update");
        if (customerType != null) {
            modelAndView.addObject("customerType", customerType);
            return modelAndView;
        }
        else {
            return modelAndView.addObject("error.404");
        }
    }

    @PostMapping("update-customer-type")
    public ModelAndView update(@ModelAttribute("customerType") CustomerType customerType) {
        ModelAndView modelAndView = new ModelAndView("customer_type/update");
        customerTypeService.saveCustomerType(customerType);
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("message", "Customer type was updated!");
        return modelAndView;
    }

    // Delete customer type
    @GetMapping("delete-customer-type/{id}")
    public ModelAndView showDeleteCustomerTypeForm(@PathVariable Integer id) {
        CustomerType customerType = customerTypeService.findById(id);
        if (customerType != null) {
            ModelAndView modelAndView = new ModelAndView("customer_type/delete");
            modelAndView.addObject("customerType", customerType);
            return modelAndView;
        }
        else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("delete-customer-type")
    public String deleteCustomerType(@ModelAttribute CustomerType customerType) {
        customerTypeService.deleteCustomerType(customerType.getId());
        return "redirect:customer-type";
    }
}
