package case_study.FuramaResort.controllers;

import FuramaResort.commons.FileManager;
import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicesController {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Villa> villas = new ArrayList<>();
    static ArrayList<House> houses = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    String patternUpperCaseFirst = "^([A-Z][a-z]+\\s?)+$";
    String patternOtherFacility = "^massage|karaoke|food|drink|car$";
    String patternTypeOfRent = "^year|month|day|hour$";
    String patternStandard = "^[1-5]\\s(star)(s?)$";

    private void addNewGeneralService(Services service) {
        do {
            System.out.println("Enter service name: ");
            service.setServiceName(scanner.nextLine());
        }
        while (!service.getServiceName().matches(patternUpperCaseFirst));

        do {
            System.out.println("Enter usable area: ");
            service.setUsedArea(scanner.nextDouble());
        }
        while (service.getUsedArea() <= 30);

        do {
            System.out.println("Enter cost: ");
            service.setCost(scanner.nextInt());
        }
        while (service.getCost() <= 0);

        do {
            System.out.println("Enter max people: ");
            service.setMaxPerson(scanner.nextInt());
        }
        while (service.getMaxPerson() < 0 || service.getMaxPerson() > 20);

        scanner.nextLine();
        do {
            System.out.println("Enter rented type: ");
            service.setRentedType(scanner.nextLine());
        }
        while (!service.getRentedType().matches(patternTypeOfRent));
    }

    void addNewVilla() {
        Villa villa = new Villa();
        String patternVillaId = "^SVVL\\d{4}$";


        do {
            System.out.println("Enter ID: ");
            villa.setId(scanner.nextLine());
        }
        while (!villa.getId().matches(patternVillaId));

        addNewGeneralService(villa);

        do {
            System.out.println("Enter the room standard: ");
            villa.setRoomStandard(scanner.nextLine());
        }
        while (!villa.getRoomStandard().matches(patternStandard));

        do {
            System.out.println("Enter other facilities: ");
            villa.setOtherFacility(scanner.nextLine());
        }
        while (!villa.getOtherFacility().matches(patternOtherFacility));

        do {
            System.out.println("Enter the number of floor: ");
            villa.setFloor(scanner.nextInt());
        }
        while (villa.getFloor() <= 0);

        do {
            System.out.println("Enter the area of swimming pool: ");
            villa.setPoolArea(scanner.nextDouble());
        }
        while (villa.getPoolArea() >= villa.getUsedArea() || villa.getPoolArea() <= 30);

        villas.add(villa);

        FileManager.writeFileCSVVilla(villas, "D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villas.csv");
    }

    void addNewHouse() {
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
            house.setRoomStandard(scanner.nextLine());
        }
        while (!house.getRoomStandard().matches(patternStandard));

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

    void addNewRoom() {
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
