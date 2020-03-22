package controllers;

import commons.FuncGeneric;
import commons.FuncWriteAndReadFileCSV;
import commons.ScannerUtils;
import models.Customer;
import models.SortNameAndYear;

import java.util.ArrayList;
import java.util.Scanner;

import static commons.FuncGeneric.displayList;
import static commons.FuncValidation.*;
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

        customer.setCustomerName(getValidCustomerName(ENTER_CUSTOMER_NAME, INVALID_CUSTOMER_NAME));

        customer.setBirthday(getValidBirthday(ENTER_BIRTHDAY, INVALID_BIRTHDAY));

        customer.setGender(getValidGender(ENTER_GENDER, INVALID_GENDER));

        customer.setIdCard(getValidIdCard(ENTER_ID_CARD, INVALID_ID_CARD));

        System.out.println("Enter the customer phone number: ");
        customer.setPhoneNumber(ScannerUtils.scanner.nextLine());

        customer.setEmail(getValidEmail(ENTER_EMAIL, INVALID_EMAIL));

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
        ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        customerList.sort(new SortNameAndYear());
        displayList(customerList);
        backMainMenu();

    }
}