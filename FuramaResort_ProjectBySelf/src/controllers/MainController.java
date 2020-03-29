package controllers;

import static commons.Exit.exit;
import static commons.GeneralScanner.scanner;
import static controllers.BookingController.*;
import static controllers.CustomerController.*;
import static controllers.EmployeeController.*;
import static controllers.ServicesController.*;
import static views.Menu.*;

public class MainController {

    public static void processMainMenu() {
        displayMainMenu();
        switch (scanner.nextInt()) {
            case 1:
                addNewService();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showCustomersInfo();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showEmployeesInfo();
                break;
            case 7:
                bookMovieTicket4D();
                break;
            case 8:
                findEmployeesRecord();
                break;
            case 9:
                exit();
            default:
                System.out.println("Enter selecting again!");
                processMainMenu();
        }
    }
}
