package controllers;

import commons.ScannerUtils;

import java.util.Scanner;

import static commons.Menu.*;
import static controllers.BookingController.*;
import static controllers.CustomerController.*;
import static controllers.EmployeeController.*;
import static controllers.ServicesController.*;

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

