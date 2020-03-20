package commons;

public class FuncWriteAndReadFileCSV {
    public static final char DEFAULT_SEPARATOR = ',';
    public static final char DEFAULT_QUOTE = '"';
    public static final int NUMBER_OF_LINE_SKIP = 1;

    public static final String PATH_VILLA = "src/case_study/FuramaResort/data/villas.csv";
    public static final String PATH_HOUSE = "src/case_study/FuramaResort/data/houses.csv";
    public static final String PATH_ROOM = "src/case_study/FuramaResort/data/rooms.csv";
    public static final String PATH_CUSTOMER = "src/case_study/FuramaResort/data/customers.csv";
    public static final String PATH_EMPLOYEE = "src/case_study/FuramaResort/data/employees.csv";
    public static final String PATH_BOOKING = "src/case_study/FuramaResort/data/bookings.csv";

    public static String[] headerRecordVilla = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS" , "SWIMMING POOL AREA"};
    public static String[] headerRecordHouse = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS"};
    public static String[] headerRecordRoom = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "FREE SERVICE"};
    public static String[] headerRecordCustomer = {"CUSTOMER NAME" , "BIRTHDAY" , "GENDER" , "ID CARD" , "PHONE NUMBER" , "EMAIL" , "CUSTOMER TYPE" , "ADDRESS"};
    public static String[] headerRecordEmployee = {};
    public static String[] headerRecordBooking = {};

}
