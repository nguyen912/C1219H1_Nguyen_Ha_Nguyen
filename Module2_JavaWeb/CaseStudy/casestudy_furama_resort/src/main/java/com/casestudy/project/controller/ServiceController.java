package com.casestudy.project.controller;

import com.casestudy.project.model.service.Service;
import com.casestudy.project.model.service.RentType;
import com.casestudy.project.model.service.Service;
import com.casestudy.project.model.service.ServiceType;
import com.casestudy.project.service.rent_type.RentTypeService;
import com.casestudy.project.service.service.ServiceService;
import com.casestudy.project.service.service_type.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    // auto list service type
    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> listServiceType() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> listRentType() {
        return rentTypeService.findAll();
    }

    // create service
    @GetMapping("create-service")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("service/create");
        Service service = new Service();
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping("create-service")
    public ModelAndView create(@Validated @ModelAttribute Service service, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("service/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        serviceService.save(service);
        modelAndView.addObject("service", service);
        modelAndView.addObject("message", "The service was created successfully!");
        return modelAndView;
    }

    // list service, search, pageable
    @GetMapping("services")
    public ModelAndView listCustomer(Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    //show update service form
    @GetMapping("update-service/{id}")
    public ModelAndView showUpdateForm(@PathVariable String id) {
        Service service = serviceService.findById(id);

        ModelAndView modelAndView;
        if (service != null) {
            modelAndView = new ModelAndView("service/update");
            modelAndView.addObject("service", service);
        }
        else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }

    //update service process
    @PostMapping("update-service")
    public ModelAndView updateCustomer(@ModelAttribute Service service, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("service/update");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        serviceService.save(service);
        modelAndView.addObject("service", service);
        modelAndView.addObject("message", "The service was updated successfully!");
        return modelAndView;
    }

    //show delete form
    @GetMapping("delete-service/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        Service service = serviceService.findById(id);

        ModelAndView modelAndView;
        if (service != null) {
            modelAndView = new ModelAndView("service/delete");
            modelAndView.addObject("service", service);
        }
        else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }

    //delete service process
    @PostMapping("delete-service")
    public String deleteCustomer(@ModelAttribute Service service) {
        serviceService.delete(service);
        return "redirect:services";
    }
}
