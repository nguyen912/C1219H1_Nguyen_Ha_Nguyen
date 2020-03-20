package controllers;

import commons.ScannerUtils;
import models.Customer;

import java.util.Scanner;

public class CustomerController {

    public static void addNewCustomer() {
        Customer customer = new Customer();

        System.out.println("Enter the customer full name: ");
        customer.setCustomerName(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer birthday: ");
        customer.setBirthday(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer gender: ");
        customer.setGender(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer ID card: ");
        customer.setIdCard(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer phone number: ");
        customer.setPhoneNumber(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer email: ");
        customer.setEmail(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer type: ");
        customer.setCustomerType(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the customer address: ");
        customer.setAddress(ScannerUtils.scanner.nextLine());
    }

    public static void showInfoCustomer() {
//            System.out.println("*******************************************************************");
//            System.out.println("*******************************************************************");
    }
}