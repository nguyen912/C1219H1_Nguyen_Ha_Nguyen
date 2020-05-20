package com.casestudy.project.service.customer_type;

import com.casestudy.project.model.people.customer.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAllCustomerType();

    CustomerType findById(Integer id);

    void saveCustomerType(CustomerType customerType);

    void deleteCustomerType(Integer id);
    

}
