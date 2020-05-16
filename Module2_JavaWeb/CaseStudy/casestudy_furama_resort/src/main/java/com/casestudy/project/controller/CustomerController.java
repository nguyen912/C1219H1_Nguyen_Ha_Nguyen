package com.casestudy.project.controller;

import com.casestudy.project.model.customer.Customer;
import com.casestudy.project.model.customer.CustomerType;
import com.casestudy.project.service.customer.CustomerService;
import com.casestudy.project.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    // auto list customer type
    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> listCustomerType() {
        return customerTypeService.findAllCustomerType();
    }

    // create customer
    @GetMapping("create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("create-customer")
    public ModelAndView create(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "The customer was created successfully!");
        return modelAndView;
    }

    // list customer, search, pageable
    @GetMapping("customers")
    public ModelAndView listCustomer(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                                     @RequestParam(value = "address", required = false, defaultValue = "") String address,
                                     @RequestParam(value = "type", required = false, defaultValue = "") String type,
                                     Pageable pageable) {

        List<CustomerType> customerTypes = new ArrayList<>();
        Page<Customer> customers = null;
        
        if (name != null && address != null && type != null) {
            for (CustomerType ct : customerTypes) {
                if (type.equalsIgnoreCase(ct.getCustomerTypeName())) {
                    customers = customerService.findCustomersByNameContainingAndAddressContainingAndCustomerType(name, address, ct, pageable);
                    break;
                }
            }
        }
        else {
            customers = customerService.findAllCustomer(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
