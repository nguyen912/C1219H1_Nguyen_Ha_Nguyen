package com.casestudy.project.service.customer;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.customer.CustomerType;
import com.casestudy.project.repository.CustomerRepository;
import com.casestudy.project.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
        return customerRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findByBirthday(Date birthday, Pageable pageable) {
        return customerRepository.findByBirthday(birthday, pageable);
    }

    @Override
    public Page<Customer> findByPhoneNumberContaining(String phoneNumber, Pageable pageable) {
        return customerRepository.findByPhoneNumberContaining(phoneNumber, pageable);
    }

    @Override
    public Page<Customer> findByCustomerType(CustomerType customerType, Pageable pageable) {
        return customerRepository.findByCustomerType(customerType, pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndBirthdayAndCustomerType(String name, Date birthday, CustomerType customerType, Pageable pageable) {
        return customerRepository.findByNameContainingAndBirthdayAndCustomerType(name, birthday, customerType, pageable);
    }

}
