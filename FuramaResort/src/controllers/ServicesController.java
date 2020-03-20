package controllers;


import case_study.FuramaResort.commons.FileManager;
import case_study.FuramaResort.commons.FuncGeneric;
import case_study.FuramaResort.commons.FuncWriteAndReadFileCSV;
import case_study.FuramaResort.commons.ScannerUtils;
import case_study.FuramaResort.models.House;
import case_study.FuramaResort.models.Room;
import case_study.FuramaResort.models.Services;
import case_study.FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

import static case_study.FuramaResort.commons.Menu.displayMainMenu;
import static case_study.FuramaResort.commons.Menu.displayMenuAddNewServices;
import static case_study.FuramaResort.controllers.MainController.backMainMenu;

public class ServicesController {
    Scanner scanner = new Scanner(System.in);
    //static ArrayList<Villa> villas = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    String patternUpperCaseFirst = "^([A-Z][a-z]+\\s?)+$";
    String patternOtherFacility = "^massage|karaoke|food|drink|car$";
    String patternTypeOfRent = "^year|month|day|hour$";
    String patternStandard = "^[1-5]\\s(star)(s?)$";

    public static void processMeuAddNewServices() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Choose the option again!");
                addNewServices();
        }
    }

    public static void addNewServices() {
        displayMenuAddNewServices();
        processMeuAddNewServices();
    }


    private static Services addNewGeneralService(Services service) {
        System.out.println("Enter ID: ");
        service.setId(ScannerUtils.scanner.nextLine());

        System.out.println("Enter service name: ");
        service.setName(ScannerUtils.scanner.nextLine());

        System.out.println("Enter usable area: ");
        service.setUsedArea(Double.parseDouble(ScannerUtils.scanner.nextLine()));

        System.out.println("Enter cost: ");
        service.setCost(Integer.parseInt(ScannerUtils.scanner.nextLine()));

        System.out.println("Enter max people: ");
        service.setMaxPeople(Integer.parseInt(ScannerUtils.scanner.nextLine()));

        System.out.println("Enter rented type: ");
        service.setType(ScannerUtils.scanner.nextLine());

        return service;

    }

    public static void addNewVilla() {
        Services villa = new Villa();

        addNewGeneralService(villa);

        System.out.println("Enter the room standard: ");
        ((Villa)villa).setStandard(ScannerUtils.scanner.nextLine());

        System.out.println("Enter other facilities: ");
        ((Villa)villa).setOtherFacility(ScannerUtils.scanner.nextLine());


        System.out.println("Enter the number of floor: ");
        ((Villa)villa).setFloor(Integer.parseInt(ScannerUtils.scanner.nextLine()));


        System.out.println("Enter the area of swimming pool: ");
        ((Villa)villa).setPoolArea(Double.parseDouble(ScannerUtils.scanner.nextLine()));

        //get list villa from CSV
        ArrayList<Villa>villaList = FuncGeneric.getListFromCSV(funcgeneric.EntityType.VILLA);

        //add villa to list
        villaList.add((Villa)villa);

        //write to CSV
        FuncWriteAndReadFileCSV.writeVillaToFileCSV(villaList);

        System.out.println("Add villa " + villa.getName() + " successfully!");

        backMainMenu();

        //FileManager.writeFileCSVVilla(villas, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villas.csv");
    }

    public static void addNewHouse() {
        House house = new House();
        String patternHouseId = "^SVHO\\d{4}$";

        do {
            System.out.println("Enter ID: ");
            house.setId(scanner.nextLine());
        }
        while (!house.getId().matches(patternHouseId));

        addNewGeneralService(house);

        do {
            System.out.println("Enter the room standard: ");
            house.setStandard(scanner.nextLine());
        }
        while (!house.getStandard().matches(patternStandard));

        do {
            System.out.println("Enter other facilities: ");
            house.setOtherFacility(scanner.nextLine());
        }
        while (!house.getOtherFacility().matches(patternOtherFacility));

        do {
            System.out.println("Enter the number of floor: ");
            house.setFloor(scanner.nextInt());
        }
        while (house.getFloor() <= 0);

        houses.add(house);

        FileManager.writeFileCSVHouse(houses, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\houses.csv");
    }

    public static void addNewRoom() {
        Room room = new Room();
        String patternRoomId = "^SVRO\\d{4}$";

        do {
            System.out.println("Enter ID: ");
            room.setId(scanner.nextLine());
        }
        while (!room.getId().matches(patternRoomId));
        addNewGeneralService(room);
        System.out.println("Enter the free service: ");
        room.setFreeService(scanner.nextLine());

        rooms.add(room);
        FileManager.writeFileCSVRoom(rooms, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\rooms.csv");
    }

    public static void showServices() {
        System.out.println("Show the services: \n" +
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

    void showAllVilla() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tROOM STANDARD\t" +
                "OTHER FACILITIES\tTHE NUMBER OF FLOORS\tSWIMMING POOL AREA");
        for (Villa villa : FileManager.readFileCSVVilla("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villas.csv")) {
            System.out.println(villa.showInfo());
        }
        System.out.println("*******************************************************************");
    }

    void showAllHouse() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tROOM STANDARD\t" +
                "OTHER FACILITIES\tTHE NUMBER OF FLOORS");
        for (House house : FileManager.readFileCSVHouse("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\houses.csv")) {
            System.out.println(house.showInfo());
        }
        System.out.println("*******************************************************************");
    }

    void showAllRoom() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tFREE SERVICE");
        for (Room room : FileManager.readFileCSVRoom("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\rooms.csv")) {
            System.out.println(room.showInfo());
        }
        System.out.println("*******************************************************************");
    }

    void showAllVillaNotDuplication() {

    }

    void showAllHouseNotDuplication() {

    }

    void showAllRoomNotDuplication() {

    }
}
