package com.casestudy.project.service.customer;

import com.casestudy.project.model.customer.Customer;
import com.casestudy.project.model.customer.CustomerType;
import com.casestudy.project.repository.CustomerRepository;
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
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByNameContaining(String name, Pageable pageable) {
        return customerRepository.findCustomerByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findCustomerByAddressContaining(String address, Pageable pageable) {
        return customerRepository.findCustomerByAddressContaining(address, pageable);
    }

    @Override
    public Page<Customer> findCustomerByNameContainingAndAddressContaining(String name, String address, Pageable pageable) {
        return customerRepository.findCustomerByNameContainingAndAddressContaining(name, address, pageable);
    }

    @Override
    public Page<Customer> findCustomersByNameContainingAndAddressContainingAndCustomerType(String name, String address, CustomerType customerType, Pageable pageable) {
        return customerRepository.findCustomersByNameContainingAndAddressContainingAndCustomerType(name, address, customerType, pageable);
    }
}
