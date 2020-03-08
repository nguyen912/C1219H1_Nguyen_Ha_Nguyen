package FuramaResort.controllers;

import FuramaResort.commons.FileManager;
import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicesController {
    Scanner scanner = new Scanner(System.in);

    public void addNewServices() throws IOException {
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
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    public String showServices() {
        return "Choose these options below: \n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n";
    }
    private void addNewGeneralService(Services service) {
        System.out.println("Enter ID: ");
        service.setId(scanner.next());

        System.out.println("Enter service name: ");
        service.setServiceName(scanner.next());

        System.out.println("Enter usable area: ");
        service.setUsedArea(scanner.nextDouble());

        System.out.println("Enter cost: ");
        service.setCost(scanner.nextInt());

        System.out.println("Enter max people: ");
        service.setMaxPerson(scanner.nextInt());

        scanner.nextLine();
        System.out.println("Enter rented type: ");
        service.setRentedType(scanner.nextLine());

    }
    private void addNewRoom() throws IOException {
        ArrayList<Services> rooms = new ArrayList<Services>();
//        Services room = new Room();
//        String confirm = null;
//        do {
//            addNewGeneralService(room);
//            System.out.println("Enter free service: ");
//            ((Room)room).setFreeService(scanner.next());
//
//            rooms.add((Room)room);
//
//            System.out.println("Do you want to stop?");
//            confirm = scanner.next();
//        }
//        while (!confirm.equals("Y"));

        rooms.add(new Room("r001", "happ room", 100, 50, 2, "day", "yoga"));
        rooms.add(new Room("r002", "family room", 200, 100, 5, "day", "take the picture"));
        FileManager.writeFileCSV(rooms,"room","D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\room.csv");
    }

    private void addNewHouse() throws IOException {
        ArrayList<Services> houses = new ArrayList<Services>();
        Services house = new House();

        addNewGeneralService(house);
        System.out.println("Enter room standard: ");
        ((House)house).setRoomStandard(scanner.nextLine());
        System.out.println("Enter other facilities: ");
        ((House)house).setOtherFacility(scanner.nextLine());
        System.out.println("Enter the number of floor: ");
        ((House)house).setFloor(scanner.nextInt());

        houses.add((House)house);

        FileManager.writeFileCSV(houses,"house","D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\house.csv");
    }

    public void addNewVilla() throws IOException {
        ArrayList<Services>villas = new ArrayList<Services>();
        Services villa = new Villa();

        addNewGeneralService(villa);
        System.out.println("Enter room standard: ");
        ((Villa)villa).setRoomStandard(scanner.nextLine());
        System.out.println("Enter other facilities: ");
        ((Villa)villa).setOtherFacility(scanner.nextLine());
        System.out.println("Enter the number of floor: ");
        ((Villa)villa).setFloor(scanner.nextInt());
        System.out.println("Enter the area of swimming pool: ");
        ((Villa) villa).setPoolArea(scanner.nextDouble());

        villas.add((Villa)villa);

        FileManager.writeFileCSV(villas,"villa","D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villa.csv");
    }
}