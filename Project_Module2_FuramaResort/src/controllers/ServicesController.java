package controllers;

import commons.*;
import models.*;

import java.util.ArrayList;

import static commons.FuncGeneric.*;
import static commons.FuncValidation.*;
import static commons.Menu.*;
import static controllers.MainController.backMainMenu;

public class ServicesController {
    public static final String ENTER_SERVICE_ID = "Enter service ID: ";
    public static final String INVALID_SERVICE_ID = "Service ID is invalid. Service ID must be format SVXX-YYYY!";
    public static final String ENTER_SERVICE_NAME = "Enter service name: ";
    public static final String INVALID_SERVICE_NAME = "Service name is invalid!";
    public static final String ENTER_AREA_USED = "Enter area used: ";
    public static final String INVALID_AREA_USED = "Area used is invalid!";
    public static final String ENTER_RENTAL_COST = "Enter rental cost: ";
    public static final String INVALID_RENTAL_COST = "rental cost is invalid!";
    public static final String ENTER_MAX_NUMBER_OF_PEOPLE = "Enter max number of people: ";
    public static final String INVALID_MAX_NUMBER_OF_PEOPLE = "max number of people is invalid!";
    public static final String ENTER_RENT_TYPE = "Enter rent type: ";
    public static final String INVALID_RENT_TYPE = "rent type is invalid!";
    public static final String ENTER_ROOM_STANDARD = "Enter room standard: ";
    public static final String INVALID_ROOM_STANDARD = "room standard is invalid!";
    public static final String ENTER_AREA_POOL = "Enter area pool: ";
    public static final String INVALID_AREA_POOL = "area pool is invalid!";
    public static final String ENTER_NUMBER_OF_FLOORS = "Enter number of floors: ";
    public static final String INVALID_NUMBER_OF_FLOORS = "number of floors is invalid!";
    public static final String ENTER_FREE_SERVICES = "Enter free services: ";
    public static final String INVALID_FREE_SERVICES = "free services is invalid!";

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
        service.setId(getValidIdService(service, ENTER_SERVICE_ID, INVALID_SERVICE_ID));
        service.setName(getValidName(ENTER_SERVICE_NAME, INVALID_SERVICE_NAME));
        service.setUsedArea(getValidNumberDouble(ENTER_AREA_USED, INVALID_AREA_USED, 30.0));
        service.setCost((int) getValidNumberDouble(ENTER_RENTAL_COST, INVALID_RENTAL_COST,0.0));
        service.setMaxPeople(getValidNumberInteger(ENTER_MAX_NUMBER_OF_PEOPLE, INVALID_MAX_NUMBER_OF_PEOPLE,1, 20));
        service.setType(getValidName(ENTER_RENT_TYPE, INVALID_RENT_TYPE));
        return service;
    }

    public static void addNewVilla() {
        Services villa = new Villa();

        villa = addNewGeneralService(villa);

        ((Villa)villa).setStandard(getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        System.out.println("Enter other facilities: ");
        ((Villa)villa).setOtherFacility(ScannerUtils.scanner.nextLine());

        ((Villa)villa).setFloor(getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_OF_FLOORS, 0));

        ((Villa)villa).setPoolArea(getValidNumberDouble(ENTER_AREA_POOL, INVALID_AREA_POOL, 30.0));

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
        Services house = new House();

        house = addNewGeneralService(house);

        ((House)house).setStandard(getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        System.out.println("Enter other facilities: ");
        ((House)house).setOtherFacility(ScannerUtils.scanner.nextLine());

        ((House)house).setFloor(getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_OF_FLOORS, 0));

        ArrayList<House> houseList = getListFromCSV(EntityType.HOUSE);

        houseList.add((House) house);

        FuncWriteAndReadFileCSV.writeHouseToFileCSV(houseList);

        System.out.println("Add house " + house.getName() + " successfully!");

        backMainMenu();


    }

    public static void addNewRoom() {
        Services room = new Room();

        room = addNewGeneralService(room);

        ((Room)room).setFreeService(getValidFreeServices(ENTER_FREE_SERVICES, INVALID_FREE_SERVICES));

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
        showAllNameNotDuplicate(EntityType.VILLA);
    }

    public static void showAllHouseNotDuplication() {
        showAllNameNotDuplicate(EntityType.HOUSE);
    }

    public static void showAllRoomNotDuplication() {
        showAllNameNotDuplicate(EntityType.ROOM);
    }
}