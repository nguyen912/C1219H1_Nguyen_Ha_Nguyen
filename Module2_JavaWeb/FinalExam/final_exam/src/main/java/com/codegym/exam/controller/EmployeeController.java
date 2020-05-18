package com.codegym.exam.controller;

import com.codegym.exam.model.Employee;
import com.codegym.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // Hiển thị danh sách tất cả nhân
    @GetMapping("/employees")
    public ModelAndView listEmployees(@PageableDefault(size = 2) Pageable pageable) {
        Iterable<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/")
    public String tryBootstrap() {
        return "employee/table";
    }
}
