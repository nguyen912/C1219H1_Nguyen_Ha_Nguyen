package controllers;

import commons.*;
import models.*;

import java.util.ArrayList;

import static commons.FuncGeneric.*;
import static commons.FuncValidation.*;
import static commons.Menu.*;
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
                backMainMenu();
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
        ArrayList<Villa> villaList = getListFromCSV(EntityType.VILLA);

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

        ArrayList<House> houseList = getListFromCSV(EntityType.HOUSE);

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

        ArrayList<Room> roomList = getListFromCSV(EntityType.ROOM);

        roomList.add((Room) room);

        FuncWriteAndReadFileCSV.writeRoomToFileCSV(roomList);

        System.out.println("Add room " + room.getName() + " successfully!");

        backMainMenu();
    }

    public static void showServices() {
        displayMenuShowServices();
        processMenuShowServices();
    }

    public static void processMenuShowServices() {
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
                backMainMenu();
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
        ArrayList<Villa> villaList = getListFromCSV(EntityType.VILLA);
        displayList(villaList);
        backMainMenu();
    }

    public static void showAllHouse() {
        ArrayList<House> houseList = getListFromCSV(EntityType.HOUSE);
        displayList(houseList);
        backMainMenu();
    }

    public static void showAllRoom() {
        ArrayList<Room> roomList = getListFromCSV(EntityType.ROOM);
        displayList(roomList);
        backMainMenu();
    }

    public static void showAllVillaNotDuplication() {

    }

    public static void showAllHouseNotDuplication() {

    }

    public static void showAllRoomNotDuplication() {

    }
}