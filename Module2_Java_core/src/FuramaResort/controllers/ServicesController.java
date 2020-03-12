package FuramaResort.controllers;

import FuramaResort.commons.FileManager;
import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicesController {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Villa>villas = new ArrayList<>();
    static ArrayList<House>houses = new ArrayList<>();
    static ArrayList<Room>rooms = new ArrayList<>();

    static String confirm;

    private void addNewGeneralService(Services service) {
        System.out.println("Enter ID: ");
        service.setId(scanner.nextLine());

        System.out.println("Enter service name: ");
        service.setServiceName(scanner.nextLine());

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

    void addNewVilla() {
        Villa villa = new Villa();
        addNewGeneralService(villa);
        System.out.println("Enter the room standard: ");
        villa.setRoomStandard(scanner.nextLine());
        System.out.println("Enter other facilities: ");
        villa.setOtherFacility(scanner.nextLine());
        System.out.println("Enter the number of floor: ");
        villa.setFloor(scanner.nextInt());
        String space = scanner.nextLine();
        System.out.println("Enter the area of swimming pool: ");
        villa.setPoolArea(scanner.nextDouble());
        villas.add(villa);


        FileManager.writeFileCSVVilla(villas,"D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villas.csv");
    }


     void addNewHouse() {
        House house = new House();

        addNewGeneralService(house);
        System.out.println("Enter the room standard: ");
        house.setRoomStandard(scanner.nextLine());
        System.out.println("Enter other facilities: ");
        house.setOtherFacility(scanner.nextLine());
        System.out.println("Enter the number of floor: ");
        house.setFloor(scanner.nextInt());

        houses.add(house);

        System.out.println("Do you want to continue? Type \"n\" to exit.");
        confirm = scanner.nextLine();

        FileManager.writeFileCSVHouse(houses,"D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\houses.csv");
    }

    void addNewRoom() {
        Room room = new Room();

        addNewGeneralService(room);
        System.out.println("Enter the free service: ");
        room.setFreeService(scanner.nextLine());

        rooms.add(room);
        FileManager.writeFileCSVRoom(rooms,"D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\rooms.csv");
    }

    void showAllVilla() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tROOM STANDARD\t" +
                "OTHER FACILITIES\tTHE NUMBER OF FLOORS\tSWIMMING POOL AREA");
        for (Villa villa : FileManager.readFileCSVVilla("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\villas.csv")) {
            System.out.println(villa);
        }
        System.out.println("*******************************************************************");
    }

    void showAllHouse() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tROOM STANDARD\t" +
                "OTHER FACILITIES\tTHE NUMBER OF FLOORS");
        for (House house : FileManager.readFileCSVHouse("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\houses.csv")) {
            System.out.println(house);
        }
        System.out.println("*******************************************************************");
    }

    void showAllRoom() {
        System.out.println("*******************************************************************");
        System.out.println("ID\tSERVICE NAME\tAREA\tCOST\tMAX PEOPLE\tRENTED TYPE\tFREE SERVICE");
        for (Room room : FileManager.readFileCSVRoom("D:\\C1219H1_Nguyen_Ha_Nguyen\\Module2_Java_core\\src\\FuramaResort\\data\\rooms.csv")) {
            System.out.println(room);
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
