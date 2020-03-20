package controllers;

import commons.FuncGeneric;
import commons.FuncWriteAndReadFileCSV;
import commons.ScannerUtils;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

import static commons.Menu.displayMainMenu;
import static commons.Menu.displayMenuAddNewServices;
import static controllers.MainController.backMainMenu;

public class ServicesController {
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
        ((Villa) villa).setStandard(ScannerUtils.scanner.nextLine());

        System.out.println("Enter other facilities: ");
        ((Villa) villa).setOtherFacility(ScannerUtils.scanner.nextLine());


        System.out.println("Enter the number of floor: ");
        ((Villa) villa).setFloor(Integer.parseInt(ScannerUtils.scanner.nextLine()));


        System.out.println("Enter the area of swimming pool: ");
        ((Villa) villa).setPoolArea(Double.parseDouble(ScannerUtils.scanner.nextLine()));

        //get list villa from CSV
        ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);

        //add villa to list
        villaList.add((Villa) villa);

        //write to CSV
        FuncWriteAndReadFileCSV.writeVillaToFileCSV(villaList);

        System.out.println("Add villa " + villa.getName() + " successfully!");

        backMainMenu();
    }

    public static void addNewHouse() {
        House house = new House();

        addNewGeneralService(house);

        System.out.println("Enter the room standard: ");
        house.setStandard(ScannerUtils.scanner.nextLine());

        System.out.println("Enter other facilities: ");
        house.setOtherFacility(ScannerUtils.scanner.nextLine());

        System.out.println("Enter the number of floor: ");
        house.setFloor(Integer.parseInt(ScannerUtils.scanner.nextLine()));

        ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);

        houseList.add((House) house);

        FuncWriteAndReadFileCSV.writeHouseToFileCSV(houseList);

        System.out.println("Add house " + house.getName() + " successfully!");

        backMainMenu();


    }

    public static void addNewRoom() {
        Room room = new Room();

        addNewGeneralService(room);

        System.out.println("Enter the free service: ");
        room.setFreeService(ScannerUtils.scanner.nextLine());

        ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);

        roomList.add((Room) room);

        FuncWriteAndReadFileCSV.writeRoomToFileCSV(roomList);

        System.out.println("Add room " + room.getName() + " successfully!");

        backMainMenu();
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

        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                showAllVilla();
                break;
            case "2":
                showAllHouse();
                break;
            case "3":
                showAllRoom();
                break;
            case "4":
                showAllVillaNotDuplication();
                break;
            case "5":
                showAllHouseNotDuplication();
                break;
            case "6":
                showAllRoomNotDuplication();
                break;
            case "7":
                displayMainMenu();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("Choose the option again!");
                showServices();
        }
    }

    public static void showAllVilla() {

    }

    public static void showAllHouse() {

    }

    public static void showAllRoom() {

    }

    public static void showAllVillaNotDuplication() {

    }

    public static void showAllHouseNotDuplication() {

    }

    public static void showAllRoomNotDuplication() {

    }
}
