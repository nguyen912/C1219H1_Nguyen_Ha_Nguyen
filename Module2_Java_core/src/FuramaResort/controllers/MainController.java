package FuramaResort.controllers;

import FuramaResort.models.Services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class MainController {
    public MainController() throws FileNotFoundException, UnsupportedEncodingException {
    }

    public static void displayMainMenu() throws IOException {
        System.out.println(
                "Choose these options below:\n" +
                        "1.	 Add New Services\n" +
                        "2.	Show Services\n" +
                        "3.	Add New Customer\n" +
                        "4.	Show Information of Customer\n" +
                        "5.	Add New Booking\n" +
                        "6.	Show Information of Employee\n" +
                        "7.	Exit"
        );
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        ServicesController servicesController = new ServicesController();
        switch (choice) {
            case 1:
                servicesController.addNewServices();
                break;
//            case 2:
//                showServices();
//                break;
//            case 3:
//                addNewCustomer();
//                break;
//            case 4:
//                showCustomerInfo();
//                break;
//            case 5:
//                addNewBooking();
//                break;
//            case 6:
//                showInfoOfEmployee();
//                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    private void showCustomerInfo() {
    }

    private void addNewBooking() {
    }

    private void showInfoOfEmployee() {
    }

    private void addNewCustomer() {
    }

    private void showServices() {
    }


}
