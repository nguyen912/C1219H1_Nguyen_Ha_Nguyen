package com.casestudy.project.controller;

import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.contract.DetailContract;
import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.service.OtherService;
import com.casestudy.project.service.contract.ContractService;
import com.casestudy.project.service.detail_contract.DetailContractService;
import com.casestudy.project.service.other_service.OtherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailContractController {
    @Autowired
    private DetailContractService detailContractService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private OtherServiceService otherServiceService;

    @ModelAttribute("contracts")
    public Iterable<Contract> listAllContracts(Pageable pageable) {
        return contractService.findAll(pageable);
    }

    @ModelAttribute("otherservices")
    public Iterable<OtherService> listAllOtherServices() {
        return otherServiceService.findAll();
    }

    @GetMapping("detailcontracts")
    public ModelAndView detailContracts(@PageableDefault(size = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("detailcontract/list");
        Iterable<DetailContract> detailContracts = detailContractService.findAll(pageable);
        modelAndView.addObject("detailContracts", detailContracts);
        return modelAndView;
    }

    @GetMapping("create-detailcontract")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("detailcontract/create");
        DetailContract detailContract = new DetailContract();
        modelAndView.addObject("detailContract", detailContract);
        return modelAndView;
    }

    @PostMapping("create-detailcontract")
    public ModelAndView create(@Validated @ModelAttribute DetailContract detailContract, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("detailcontract/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingResult", bindingResult);
            return modelAndView;
        }
        detailContractService.save(detailContract);
        modelAndView.addObject("detailContract", detailContract);
        modelAndView.addObject("message", "The detail contract was created successfully!");
        return modelAndView;
    }
}
