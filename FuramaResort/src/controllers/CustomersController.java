package controllers;


import case_study.FuramaResort.commons.FileManager;
import case_study.FuramaResort.models.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class CustomersController {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Customer>customers = new ArrayList<>();
    Customer customer = new Customer();

    public static void addNewCustomer() {
        String namePattern = "^([A-Z][a-z]+\\s?)+$";
        String emailPattern = "^\\w+@[a-z]+(.[a-z]+){1,2}$";
        String idCardPattern = "^\\d{9}$";

        do {
            System.out.println("Enter the customer full name: ");
            customer.setCustomerName(scanner.nextLine());
        }
        while (!customer.getCustomerName().matches(namePattern));

        System.out.println("Enter the customer birthday: ");
        customer.setBirthday(scanner.next());

        System.out.println("Enter the customer gender: ");
        customer.setGender(scanner.nextLine());

        do {
            System.out.println("Enter the customer ID card: ");
            customer.setIdCard(scanner.nextLine());
        }
        while (!customer.getIdCard().matches(idCardPattern));

        System.out.println("Enter the customer phone number: ");
        customer.setPhoneNumber(scanner.nextLine());

        do {
            System.out.println("Enter the customer email: ");
            customer.setEmail(scanner.nextLine());
        }
        while (!customer.getEmail().matches(emailPattern));

        System.out.println("Enter the customer type: ");
        customer.setCustomerType(scanner.nextLine());

        System.out.println("Enter the customer address: ");
        customer.setAddress(scanner.nextLine());

        customers.add(customer);
        FileManager.writeFileCSVCustomer(customers, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\customers.csv");
    }

    public static void showInfoCustomer() {
        ArrayList<Customer> customers = FileManager.readFileCSVCustomer("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\customers.csv");

        System.out.println("*******************************************************************");
        System.out.println("CUSTOMER NAME\tBIRTHDAY\tGENDER\tID CARD\tPHONE NUMBER\tEMAIL\t" +
                "CUSTOMER TYPE\tADDRESS");
        Collections.sort(customers);

        for (Customer customer : customers) {
            System.out.println(customer.showIfo());
        }
        System.out.println("*******************************************************************");
    }
}
