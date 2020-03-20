package commons;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static commons.FuncWriteAndReadFileCSV.*;

public class FuncGeneric {
    public enum EntityType {
        VILLA,
        HOUSE,
        ROOM,
        CUSTOMER,
        EMPLOYEE
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
}
