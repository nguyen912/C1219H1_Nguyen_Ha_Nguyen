package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    public static Map<Integer, Customer> customerList = new HashMap<>();

    private static void initCustomer() {
        Customer customer1 = new Customer(1,"Nguyen Ha Nguyen", "09/12/1998", "78TNV");
        Customer customer2 = new Customer(2,"Nguyen Toan Thang", "09/12/1998", "78TNV");
        Customer customer3 = new Customer(3,"Phan Manh Quynh", "09/12/1998", "78TNV");
        Customer customer4 = new Customer(4,"Hoang Tuyet Hau", "09/12/1998", "78TNV");
        Customer customer5 = new Customer(5,"Le Trung Dung", "09/12/1998", "78TNV");

        customerList.put(customer1.getId(), customer1);
        customerList.put(customer2.getId(), customer2);
        customerList.put(customer3.getId(), customer3);
        customerList.put(customer4.getId(), customer4);
        customerList.put(customer5.getId(), customer5);
    }

    public static List<Customer> getAllCustomers() {
        Collection<Customer> c = customerList.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }

}
