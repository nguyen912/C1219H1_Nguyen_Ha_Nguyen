package controllers;


import case_study.FuramaResort.commons.ScannerUtils;
import case_study.FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static case_study.FuramaResort.commons.Menu.displayMainMenu;
import static case_study.FuramaResort.commons.Menu.displayMenuBackToMain;
import static case_study.FuramaResort.controllers.BookingController.addNewBooking;
import static case_study.FuramaResort.controllers.BookingController.bookingMovieTicket4D;
import static case_study.FuramaResort.controllers.CustomersController.addNewCustomer;
import static case_study.FuramaResort.controllers.CustomersController.showInfoCustomer;
import static case_study.FuramaResort.controllers.EmployeeController.findEmployeeFromResume;
import static case_study.FuramaResort.controllers.EmployeeController.showInfoEmployee;
import static case_study.FuramaResort.controllers.ServicesController.addNewServices;
import static case_study.FuramaResort.controllers.ServicesController.showServices;

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


