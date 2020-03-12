package FuramaResort.controllers;

import FuramaResort.commons.FileManager;
import FuramaResort.models.Customer;
import FuramaResort.models.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomersController {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer>customers = new ArrayList<>();
    Customer customer = new Customer();

    public void addNewCustomer() {
        System.out.println("Enter the customer full name: ");
        customer.setCustomerName(scanner.nextLine());

        System.out.println("Enter the customer birthday: ");
        customer.setBirthday(scanner.nextLine());

        System.out.println("Enter the customer gender: ");
        customer.setGender(scanner.nextLine());

        System.out.println("Enter the customer ID card: ");
        customer.setIdCard(scanner.nextLine());

        System.out.println("Enter the customer phone number: ");
        customer.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter the customer email: ");
        customer.setEmail(scanner.nextLine());

        System.out.println("Enter the customer type: ");
        customer.setCustomerType(scanner.nextLine());

        System.out.println("Enter the customer address: ");
        customer.setAddress(scanner.nextLine());

        customers.add(customer);
        FileManager.writeFileCSVCustomer(customers, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\customers.csv");
    }

    public void showInfoCustomer() {
        System.out.println("*******************************************************************");
        System.out.println("CUSTOMER NAME\tBIRTHDAY\tGENDER\tID CARD\tPHONE NUMBER\tEMAIL\t" +
                "CUSTOMER TYPE\tADDRESS");
        for (Customer customer : FileManager.readFileCSVCustomer("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\customers.csv")) {
            System.out.println(customer);
        }
        System.out.println("*******************************************************************");
    }
}
