package com.example.demo.service.customer;

import com.example.demo.model.Classify;
import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomersByNameContainingAndProvinceContainingAndClassifyContainingAndBirthdayContaining(String name, Province province, Classify classify, String birthday) {
        return customerRepository.findCustomersByNameContainingAndProvinceContainingAndClassifyContainingAndBirthdayContaining(name, province, classify, birthday);
    }
}
