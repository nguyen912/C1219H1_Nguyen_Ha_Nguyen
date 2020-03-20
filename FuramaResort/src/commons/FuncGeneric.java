package commons;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static case_study.FuramaResort.commons.FuncWriteAndReadFileCSV.*;

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

        return ;
    }
}
