package com.casestudy.project.service.customer_type;

import com.casestudy.project.model.customer.Customer;
import com.casestudy.project.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerTypeService {
    Iterable<CustomerType> findAllCustomerType();

    CustomerType findById(Integer id);

    void saveCustomerType(CustomerType customerType);

    void deleteCustomerType(Integer id);
    

}
