package controllers;

import commons.Generic;
import commons.Exit;
import models.Services;
import models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

import static commons.FileManagement.*;
import static commons.GeneralScanner.scanner;
import static controllers.MainController.processMainMenu;
import static views.Menu.*;

public class ServicesController {
    public static void addNewService() {
        displayAddingNewServicesMenu();

        switch (scanner.nextInt()) {
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
                processMainMenu();
                break;
            case 5:
                Exit.exit();
            default:
                System.out.println("Enter selecting again!");
                addNewService();
        }
    }

    private static Services addNewGeneralService(Services services) {
        System.out.println("Enter service ID: ");
        services.setServiceId(new Scanner(System.in).nextLine());

        System.out.println("Enter service name: ");
        services.setServiceName(new Scanner(System.in).nextLine());

        System.out.println("Enter usable area");
        services.setUsableArea(scanner.nextDouble());

        System.out.println("Enter rental cost: ");
        services.setRentalCost(scanner.nextInt());

        System.out.println("Enter maximum number of people: ");
        services.setMaxPeople(scanner.nextInt());

        System.out.println("Enter type of rent:");
        services.setTypeOfRent(new Scanner(System.in).nextLine());

        return services;

    }

    private static void addNewRoom() {

    }

    private static void addNewHouse() {
    }

    private static void addNewVilla() {
        Services villa = new Villa();
        villa = addNewGeneralService(villa);
        ArrayList<Villa> villas = new ArrayList<>();

        System.out.println("Enter Standard: ");
        ((Villa) villa).setStandard(new Scanner(System.in).nextLine());

        System.out.println("Enter Other Comfort Description");
        ((Villa) villa).setOtherComfortDescription(new Scanner(System.in).nextLine());

        System.out.println("Enter Pool Area: ");
        ((Villa) villa).setPoolArea(scanner.nextDouble());

        System.out.println("Enter Number Of Floors");
        ((Villa) villa).setNumberOfFloors(scanner.nextInt());

        villas.add(((Villa) villa));

        writeFileCSV(villas);

    }

    public static void showServices() {

    }
}
