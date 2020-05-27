package com.casestudy.project.controller;

import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.staff.Employee;
import com.casestudy.project.model.service.Service;
import com.casestudy.project.service.contract.ContractService;
import com.casestudy.project.service.customer.CustomerService;
import com.casestudy.project.service.employee.EmployeeService;
import com.casestudy.project.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("customers")
    public Iterable<Customer> listAllCustomers(Pageable pageable) {
        return customerService.findAllCustomer(pageable);
    }

    @ModelAttribute("employees")
    public Iterable<Employee> listAllEmployees(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ModelAttribute("services")
    public Iterable<Service> listAllServices(Pageable pageable) {
        return serviceService.findAll(pageable);
    }

    @GetMapping("create-contract")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        Contract contract = new Contract();
        modelAndView.addObject("contract", contract);
        return modelAndView;
    }

    @PostMapping("create-contract")
    public ModelAndView create(@Validated @ModelAttribute Contract contract, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        contractService.save(contract);
        modelAndView.addObject("contract", contract);
        modelAndView.addObject("message", "The contract was created successfully!");
        return modelAndView;
    }

    @GetMapping("contracts")
    public ModelAndView listCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Iterable<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    //find customers don't have contract end date
    public ModelAndView listPresentCustomers(@PageableDefault(size = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/present");
        Page<Customer> customers = customerService.findAllCustomer(pageable);
        Iterable<Contract> contracts = contractService.findAll(pageable);

        List<Contract> presentContracts = null;
        for (Contract contract : contracts) {
            if (contract.getContractEndDate() == null) {
                presentContracts.add(contract);
            }
        }

        for (Contract pc : presentContracts) {
            pc.getCustomer().getName();
        }
            return modelAndView;
    }
}
