package FuramaResort.controllers;

import FuramaResort.models.Services;

import java.util.Scanner;

public class MainController {
    ServicesController servicesController = new ServicesController();
    Scanner scanner = new Scanner(System.in);
    public void displayMainMenu() {

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
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addNewServices();
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
//            case 7:
//                System.exit(0);
//                break;
        }
    }

    public void addNewServices() {


        System.out.println(
            "Choose these services below: " +
                "1. Add New Villa" +
                "2.	Add New House" +
                "3.	Add New Room" +
                "4.	Back to menu" +
                "5.	Exit"
        );

        int chooseService = scanner.nextInt();
        switch (chooseService) {
            case 1:
                servicesController.addNewVilla();
                break;
//            case 2:
//                addNewHouse();
//                break;
//            case 3:
//                addNewRoom();
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//            case 5:
//                System.exit(0);
        }
    }
}
