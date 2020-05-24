package com.casestudy.project.controller;

import com.casestudy.project.model.people.staff.Employee;
import com.casestudy.project.model.people.staff.Degree;
import com.casestudy.project.model.people.staff.Department;
import com.casestudy.project.model.people.staff.Role;
import com.casestudy.project.service.degree.DegreeService;
import com.casestudy.project.service.department.DepartmentService;
import com.casestudy.project.service.employee.EmployeeService;
import com.casestudy.project.service.role.RoleService;
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

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DegreeService degreeService;

    @ModelAttribute("roles")
    public Iterable<Role> listAllRoles() {
        return roleService.findAll();
    }

    @ModelAttribute("degrees")
    public Iterable<Degree> listAllDegrees() {
        return degreeService.findAll();
    }

    @ModelAttribute("departments")
    public Iterable<Department> listAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("create-employee")
    public ModelAndView create(@Validated @ModelAttribute Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        employeeService.save(employee);
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "The employee was created successfully!");
        return modelAndView;
    }

    @GetMapping("employees")
    public ModelAndView listEmployee(@PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
