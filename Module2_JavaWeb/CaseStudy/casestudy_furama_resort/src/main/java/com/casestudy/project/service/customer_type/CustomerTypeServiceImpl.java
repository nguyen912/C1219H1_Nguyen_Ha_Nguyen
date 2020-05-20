package com.casestudy.project.service.customer_type;

import com.casestudy.project.model.people.customer.CustomerType;
import com.casestudy.project.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomerType(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void deleteCustomerType(Integer id) {
        customerTypeRepository.deleteById(id);
    }



}
