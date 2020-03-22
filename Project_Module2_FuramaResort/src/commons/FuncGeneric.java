package commons;

import com.opencsv.bean.*;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

import static commons.FuncWriteAndReadFileCSV.*;
import static controllers.MainController.backMainMenu;

public class FuncGeneric {
    public enum EntityType {
        VILLA,
        HOUSE,
        ROOM,
        CUSTOMER,
        EMPLOYEE
    }

    public static <E> void displayList(ArrayList<E> list) {
        int i = 1;
        System.out.println("===============================================================");
        for (E item : list) {
            System.out.printf("No." + i);
            if (item instanceof Villa) {
                ((Villa)item).showInfo();
            }
            else if (item instanceof House) {
                ((House)item).showInfo();
            }
            else if (item instanceof Room) {
                ((Room)item).showInfo();
            }
            else if (item instanceof Customer) {
                ((Customer)item).showInfo();
            }
            else if (item instanceof Employee) {
                ((Employee)item).showInfo();
            }
            i++;
        }
        System.out.println("===============================================================");
    }

    public static <E> ArrayList<E> getListFromCSV(EntityType entityType) {
        String csvPath = "";
        String[] headerRecord;

        switch (entityType) {
            case VILLA:
                csvPath = PATH_VILLA;
                headerRecord = headerRecordVilla;
                break;
            case HOUSE:
                csvPath = PATH_HOUSE;
                headerRecord = headerRecordHouse;
                break;
            case ROOM:
                csvPath = PATH_ROOM;
                headerRecord = headerRecordRoom;
                break;
            case CUSTOMER:
                csvPath = PATH_CUSTOMER;
                headerRecord = headerRecordCustomer;
                break;
            case EMPLOYEE:
                csvPath = PATH_EMPLOYEE;
                headerRecord = headerRecordEmployee;
                break;
            default:
                throw new IllegalStateException("Unexpected value" + entityType);
        }

        Path path = Paths.get(csvPath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(csvPath);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        ColumnPositionMappingStrategy<E> strategy = new ColumnPositionMappingStrategy<>();

        switch (entityType) {
            case VILLA:
                strategy.setType((Class<? extends E>) Villa.class);
                break;
            case HOUSE:
                strategy.setType((Class<? extends E>) House.class);
                break;
            case ROOM:
                strategy.setType((Class<? extends E>) Room.class);
                break;
            case CUSTOMER:
                strategy.setType((Class<? extends E>) Customer.class);
                break;
            case EMPLOYEE:
                strategy.setType((Class<? extends E>) Employee.class);
                break;
            default:
        }

        strategy.setColumnMapping(headerRecord);

        CsvToBean<E> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<E>(new FileReader(csvPath))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUMBER_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (ArrayList<E>)csvToBean.parse();
    }

    public static void showAllNameNotDuplicate(EntityType entityType) {
        String csvPath = "";

        switch (entityType) {
            case VILLA:
                csvPath = PATH_VILLA;
                break;
            case HOUSE:
                csvPath = PATH_HOUSE;
                break;
            case ROOM:
                csvPath = PATH_ROOM;
                break;
        }

        Path path = Paths.get(csvPath);
        if (!Files.exists(path)) {
            System.out.println("File CSV does not exist!");
            backMainMenu();
        }
        TreeSet<String> treeSet = FuncWriteAndReadFileCSV.getAllNameServiceFromCSV(csvPath);
        System.out.println("List name service does not duplicate: ");
        for (String str : treeSet) {
            System.out.println(str);
            System.out.println("========================");
        }
        backMainMenu();

    }
}