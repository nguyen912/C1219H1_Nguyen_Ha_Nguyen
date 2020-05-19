package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers.put(1, new Customer(1, "Nguyen", "Diamond"));
        customers.put(2, new Customer(2, "Hoang", "Diamond"));
        customers.put(3, new Customer(3, "Ha", "Diamond"));
        customers.put(4, new Customer(4, "Thien", "Diamond"));
        customers.put(5, new Customer(5, "Tinh", "Diamond"));
    }

    public static List<Customer> listCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerList.addAll(customers.values());
        return customerList;
    }
}
