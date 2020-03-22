package controllers;

import commons.FuncGeneric;
import commons.FuncWriteAndReadFileCSV;
import commons.ScannerUtils;
import models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

import static controllers.MainController.backMainMenu;

public class CustomerController {
    public static final String ENTER_CUSTOMER_NAME = "Enter customer name: ";
    public static final String INVALID_CUSTOMER_NAME = "customer name is invalid!";
    public static final String ENTER_GENDER = "Enter gender: ";
    public static final String INVALID_GENDER = "gender is invalid!";
    public static final String ENTER_ID_CARD = "Enter id card: ";
    public static final String INVALID_ID_CARD = "id card is invalid!";
    public static final String ENTER_EMAIL = "Enter email: ";
    public static final String INVALID_EMAIL = "email is invalid!";
    public static final String ENTER_BIRTHDAY = "Enter birthday: ";
    public static final String INVALID_BIRTHDAY = "birthday is invalid!";

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

        ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        customerList.add(customer);
        FuncWriteAndReadFileCSV.writeCustomerToFileCSV(customerList);

        System.out.println("Add customer " + customer.getCustomerName() + " successfully!");
        backMainMenu();
    }

    public static void showInfoCustomer() {
//            System.out.println("*******************************************************************");
//            System.out.println("*******************************************************************");
    }
}