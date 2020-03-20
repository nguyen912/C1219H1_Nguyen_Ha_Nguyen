package controllers;

import commons.ScannerUtils;

import java.util.Scanner;

import static commons.Menu.displayMainMenu;
import static commons.Menu.displayMenuBackToMain;
import static controllers.BookingController.addNewBooking;
import static controllers.BookingController.bookingMovieTicket4D;
import static controllers.CustomersController.addNewCustomer;
import static controllers.CustomersController.showInfoCustomer;
import static controllers.EmployeeController.findEmployeeFromResume;
import static controllers.EmployeeController.showInfoEmployee;
import static controllers.ServicesController.addNewServices;
import static controllers.ServicesController.showServices;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    public static void processMain() {
        try {
            displayMainMenu();
            processMainMenu();
        }
        catch (Exception ex) {
            backMainMenu();
        }
    }

    public static void processMainMenu() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInfoCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInfoEmployee();
                break;
            case "7":
                bookingMovieTicket4D();
                break;
            case "8":
                findEmployeeFromResume();
                break;
            case "9":
                System.out.println("Thank you for using the software!");
                System.exit(0);
                break;
            default:
                System.out.println("Choose again!");
                backMainMenu();
        }
    }

    public static void backMainMenu() {
        displayMenuBackToMain();
        processMain();
    }
}


