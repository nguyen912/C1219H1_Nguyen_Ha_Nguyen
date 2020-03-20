package commons;

import com.opencsv.CSVWriter;
import models.House;
import models.Room;
import models.Villa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class FuncWriteAndReadFileCSV {
    public static final char DEFAULT_SEPARATOR = ',';
    public static final char DEFAULT_QUOTE = '"';
    public static final int NUMBER_OF_LINE_SKIP = 1;

    public static final String PATH_VILLA = "src/data/villas.csv";
    public static final String PATH_HOUSE = "src/data/houses.csv";
    public static final String PATH_ROOM = "src/data/rooms.csv";
    public static final String PATH_CUSTOMER = "src/data/customers.csv";
    public static final String PATH_EMPLOYEE = "src/data/employees.csv";
    public static final String PATH_BOOKING = "src/data/bookings.csv";

    public static String[] headerRecordVilla = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS" , "SWIMMING POOL AREA"};
    public static String[] headerRecordHouse = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS"};
    public static String[] headerRecordRoom = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "FREE SERVICE"};
    public static String[] headerRecordCustomer = {"CUSTOMER NAME" , "BIRTHDAY" , "GENDER" , "ID CARD" , "PHONE NUMBER" , "EMAIL" , "CUSTOMER TYPE" , "ADDRESS"};
    public static String[] headerRecordEmployee = {};
    public static String[] headerRecordBooking = {};

    public static void writeVillaToFileCSV(ArrayList<Villa> arrayList) {
        try {
            Writer writer = new FileWriter(PATH_VILLA);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : arrayList) {
                csvWriter.writeNext(new String[]
                        {villa.getId(), villa.getName(), String.valueOf(villa.getUsedArea()),
                        String.valueOf(villa.getCost()), String.valueOf(villa.getMaxPeople()),
                        villa.getType(), villa.getStandard(), villa.getOtherFacility(),
                        String.valueOf(villa.getFloor()), String.valueOf(villa.getPoolArea())});
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeHouseToFileCSV(ArrayList<House> arrayList) {
        try {
            Writer writer = new FileWriter(PATH_HOUSE);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            csvWriter.writeNext(headerRecordHouse);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]
                        {house.getId(), house.getName(), String.valueOf(house.getUsedArea()),
                        String.valueOf(house.getCost()), String.valueOf(house.getMaxPeople()),
                        house.getType(), house.getStandard(), house.getOtherFacility(),
                        String.valueOf(house.getFloor())});
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeRoomToFileCSV(ArrayList<Room> arrayList) {
        try {
            Writer writer = new FileWriter(PATH_ROOM);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]
                        {room.getId(), room.getName(), String.valueOf(room.getUsedArea()),
                        String.valueOf(room.getCost()), String.valueOf(room.getMaxPeople()),
                        room.getType(), room.getFreeService()});
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
