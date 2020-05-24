package com.casestudy.project.controller;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import com.casestudy.project.service.customer.CustomerService;
import com.casestudy.project.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.text.ParseException;

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
    public ModelAndView create(@Validated @ModelAttribute Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        customerService.saveCustomer(customer);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "The customer was created successfully!");
        return modelAndView;
    }

    // list customer, search, pageable
    @GetMapping("customers")
    public ModelAndView listCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAllCustomer(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    
    //show update customer form
    @GetMapping("update-customer/{id}")
    public ModelAndView showUpdateForm(@PathVariable String id) {
        Customer customer = customerService.findCustomerById(id);

        ModelAndView modelAndView;
        if (customer != null) {
            modelAndView = new ModelAndView("customer/update");
            modelAndView.addObject("customer", customer);
        }
        else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }

    //update customer process
    @PostMapping("update-customer")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("customer/update");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        customerService.saveCustomer(customer);
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "The customer was updated successfully!");
        return modelAndView;
    }

    //show delete form
    @GetMapping("delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        Customer customer = customerService.findCustomerById(id);

        ModelAndView modelAndView;
        if (customer != null) {
            modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer", customer);
        }
        else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }

    //delete customer process
    @PostMapping("delete-customer")
    public String deleteCustomer(@ModelAttribute Customer customer) {
        customerService.deleteCustomer(customer);
        return "redirect:customers";
    }

    //search by each condition
    @GetMapping("search-each")
    public ModelAndView searchEachCondition(@RequestParam(name = "search") String search, @RequestParam(name = "input") String input, @PageableDefault(size = 3) Pageable pageable) throws ParseException{
        Page<Customer> customers = null;

        switch (search) {
            case "name":
                if (input != null) {
                    customers = customerService.findByNameContaining(input, pageable);
                }
                else {
                    customers = customerService.findAllCustomer(pageable);
                }
                break;

            case "birthday":
                Date dob = Date.valueOf(input);
                if (dob != null) {
                    customers = customerService.findByBirthday(dob, pageable);
                }
                else {
                    customers = customerService.findAllCustomer(pageable);
                }
                break;

            case "phone":
                if (input != null) {
                    customers = customerService.findByPhoneNumberContaining(input, pageable);
                }
                else {
                    customers = customerService.findAllCustomer(pageable);
                }
                break;
        }

        ModelAndView modelAndView = new ModelAndView("customer/searcheach");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("search", search);
        modelAndView.addObject("input", input);
        return modelAndView;
    }

    //search all conditions
    @GetMapping("search-all")
    public ModelAndView searchAll(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                  @RequestParam(name = "birthday", required = false, defaultValue = "") Date birthday,
                                  @RequestParam(name = "customerType", required = false, defaultValue = "") Integer customerTypeId,
                                  @PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers;
        CustomerType customerType = customerTypeService.findById(Integer.valueOf(customerTypeId));
        customers = customerService.findByNameContainingAndBirthdayAndCustomerType(name, birthday, customerType, pageable);

        ModelAndView modelAndView = new ModelAndView("customer/searchall");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("name", name);
        modelAndView.addObject("birthday", birthday);
        modelAndView.addObject("customerType", customerType);
        return modelAndView;
    }
}
