package FuramaResort.controllers;

import FuramaResort.models.House;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static List<Villa> villas = new ArrayList<>();

    static ServicesController servicesController = new ServicesController();
    static CustomersController customersController = new CustomersController();

    public static void displayMainMenu() {
        System.out.println(
                "Choose these options below: \n" +
                "        1.\t Add New Services\n" +
                "        2.\tShow Services\n" +
                "        3.\tAdd New Customer\n" +
                "        4.\tShow Information of Customer\n" +
                "        5.\tAdd New Booking\n" +
                "        6.\tShow Information of Employee\n" +
                "        7.\tExit");

        Scanner scanner = new Scanner(System.in);
        int chooseFunc = scanner.nextInt();

        switch (chooseFunc) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                customersController.addNewCustomer();
                break;
            case 4:
                customersController.showInfoCustomer();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showInfoEmployee();
                break;
            case 7:
                System.out.println("Thank you for using the software!");
                System.exit(0);
                break;
            default:
                System.out.println("Choose the option again!");
                displayMainMenu();
        }
    }

    private static void addNewServices() {
        System.out.println(
                "Choose these options below: \n" +
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        int chooseService = scanner.nextInt();
        switch (chooseService) {
            case 1:
                servicesController.addNewVilla();
                break;
            case 2:
                servicesController.addNewHouse();
                break;
            case 3:
                servicesController.addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Choose the option again!");
                addNewServices();
        }
    }

    private static void showServices() {
        System.out.println("Show the services: " +
                            "1.\tShow all Villa\n" +
                            "2.\tShow all House\n" +
                            "3.\tShow all Room\n" +
                            "4.\tShow All Name Villa Not Duplicate\n" +
                            "5.\tShow All Name House Not Duplicate\n" +
                            "6.\tShow All Name Room Not Duplicate\n" +
                            "7.\tBack to menu\n" +
                            "8.\tExit\n");

        int chooseDisplay = scanner.nextInt();
        switch (chooseDisplay) {
            case 1:
                servicesController.showAllVilla();
                break;
            case 2:
                servicesController.showAllHouse();
                break;
            case 3:
                servicesController.showAllRoom();
                break;
            case 4:
                servicesController.showAllVillaNotDuplication();
                break;
            case 5:
                servicesController.showAllHouseNotDuplication();
                break;
            case 6:
                servicesController.showAllRoomNotDuplication();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Choose the option again!");
                showServices();
        }
    }


    private static void showInfoEmployee() {
    }

    private static void addNewBooking() {
    }

}
