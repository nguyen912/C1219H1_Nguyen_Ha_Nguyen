package controllers;

import commons.FuncGeneric;
import commons.FuncWriteAndReadFileCSV;
import commons.ScannerUtils;
import models.Customer;
import models.House;
import models.Room;
import models.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static commons.FuncGeneric.displayList;
import static commons.FuncGeneric.getListFromCSV;
import static commons.Menu.displayMenuBooking;
import static commons.Menu.displayMenuBookingMovieTicket4D;
import static controllers.MainController.backMainMenu;

public class BookingController {
    private static Queue<Customer> customerQueueBookingTicket = new LinkedList<Customer>();

    public static void addNewBooking() {
        ArrayList<Customer>customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        displayList(customerList);
        System.out.println("Choose one customer to booking.");
        Customer customer = new Customer();
        customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
        displayMenuBooking();
        processMenuBooking(customer);

        //get list customer from CSV
        ArrayList<Customer> listBooking = FuncWriteAndReadFileCSV.getBookingFromCSV();

        //add customer to list
        listBooking.add(customer);

        //write to CSV
        FuncWriteAndReadFileCSV.writeBookingToFileCSV(listBooking);

        System.out.println("Add booking for: " + customer.getCustomerName() + " successfully!");
        backMainMenu();
    }

    private static void processMenuBooking(Customer customer) {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
                displayList(villaList);
                System.out.println("... Choose villa booking ...");
                Villa villa = villaList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setUsingService(villa);
                break;
            case "2":
                ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
                displayList(houseList);
                System.out.println("... Choose house booking ...");
                House house = houseList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setUsingService(house);
                break;
            case "3":
                ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
                displayList(roomList);
                System.out.println("... Choose room booking ...");
                Room room = roomList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setUsingService(room);
                break;
            default:
                backMainMenu();
                break;
        }
    }
    public static void bookingMovieTicket4D() {
        displayMenuBookingMovieTicket4D();
        processMenuBookingMovieTicket4D();
    }

    public static void processMenuBookingMovieTicket4D() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addBookingMovieTicket4D();
                break;
            case "2":
                showBookingMovieTicket4D();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Error! Back to menu.");
                backMainMenu();
        }
    }

    private static void addBookingMovieTicket4D() {
        //select customer booking ticket
        try {
            ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
            displayList(customerList);
            System.out.println("Choose customer want to booking.");
            Customer customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
            customerQueueBookingTicket.add(customer);
            System.out.println("Add booking for: " + customer.getCustomerName() + " successfully!");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Customer booking movie ticket 4D not exist. Try again!");
            addBookingMovieTicket4D();
        }
        backMainMenu();
    }

    private static void showBookingMovieTicket4D() {
        int i = 1;
        System.out.println("===============LIST================");
        for (Customer customer : customerQueueBookingTicket) {
            System.out.println("No. " + i);
            customer.showInfo();
            i++;
            System.out.println("===================");
        }
        backMainMenu();
    }
}