package commons;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import models.Customer;
import models.House;
import models.Room;
import models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    public static final char DEFAULT_SEPARATOR = ',';
    public static final char DEFAULT_QUOTE = '"';
    public static final int NUMBER_OF_LINE_SKIP = 1;

    public static final String PATH_VILLA = "src/data/villas.csv";
    public static final String PATH_HOUSE = "src/data/houses.csv";
    public static final String PATH_ROOM = "src/data/rooms.csv";
    public static final String PATH_CUSTOMER = "src/data/customers.csv";
    public static final String PATH_EMPLOYEE = "src/data/employees.csv";
    public static final String PATH_BOOKING = "bookings.csv";

    public static String[] headerRecordVilla = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS" , "SWIMMING POOL AREA"};
    public static String[] headerRecordHouse = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "ROOM STANDARD" , "THE OTHER FACILITIES" , "THE NUMBER OF FLOORS"};
    public static String[] headerRecordRoom = {"ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE" , "FREE SERVICE"};
    public static String[] headerRecordCustomer = {"CUSTOMER NAME" , "BIRTHDAY" , "GENDER" , "ID CARD" , "PHONE NUMBER" , "EMAIL" , "CUSTOMER TYPE" , "ADDRESS"};
    public static String[] headerRecordBooking = {"CUSTOMER NAME" , "BIRTHDAY" , "GENDER" , "ID CARD" , "PHONE NUMBER" , "EMAIL" , "CUSTOMER TYPE" , "ADDRESS", "ID" , "SERVICE NAME" , "AREA" , "COST" , "MAX PEOPLE" , "RENTED TYPE"};
    public static String[] headerRecordEmployee = {};

    public static void writeVillaToFileCSV(ArrayList<Villa> arrayList) {
        try (
            Writer writer = new FileWriter(PATH_VILLA);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
        ){
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
        try (
            Writer writer = new FileWriter(PATH_HOUSE);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
        ){
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
        try (
            Writer writer = new FileWriter(PATH_ROOM);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
        ){
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

    public static void writeCustomerToFileCSV(ArrayList<Customer> arrayList) {
        try (
            Writer writer = new FileWriter(PATH_CUSTOMER);
            CSVWriter csvWriter = new CSVWriter(
                    writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
        ){
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getCustomerName(), customer.getBirthday(), customer.isGender(),
                        customer.getIdCard(), customer.getPhoneNumber(), customer.getEmail(),
                        customer.getCustomerType(), customer.getAddress()});
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeBookingToFileCSV(ArrayList<Customer> arrayList) {
        try (
                Writer writer = new FileWriter(PATH_BOOKING);
                CSVWriter csvWriter = new CSVWriter(
                        writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END
                );
        ){
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getCustomerName(), customer.getBirthday(), customer.isGender(), customer.getIdCard(), customer.getPhoneNumber(), customer.getEmail(), customer.getCustomerType(), customer.getAddress(),
                        customer.getUsingService().getId(), customer.getUsingService().getName(), String.valueOf(customer.getUsingService().getUsedArea()), String.valueOf(customer.getUsingService().getCost()), String.valueOf(customer.getUsingService().getMaxPeople()), customer.getUsingService().getType()});

            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Customer> getBookingFromCSV() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try (
            Reader reader = new FileReader(PATH_BOOKING);
            CSVReader csvReader = new CSVReader(reader);
        ){
            String[] line;
            csvReader.skip(1);
            while ((line = csvReader.readNext()) != null) {
                Customer customer = new Customer();
                Villa villa = new Villa();
                int position = 0;
                customer.setCustomerName(line[position++]);
                customer.setBirthday(line[position++]);
                customer.setGender(line[position++]);
                customer.setIdCard(line[position++]);
                customer.setPhoneNumber(line[position++]);
                customer.setEmail(line[position++]);
                customer.setCustomerType(line[position++]);
                customer.setAddress(line[position++]);

                villa.setId(line[position++]);
                villa.setName(line[position++]);
                villa.setUsedArea(Double.parseDouble(line[position++]));
                villa.setCost(Integer.parseInt(line[position++]));
                villa.setMaxPeople(Integer.parseInt(line[position++]));
                villa.setType(line[position++]);

                customer.setUsingService(villa);
                listCustomer.add(customer);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listCustomer;
    }

    public static TreeSet<String> getAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if (getNameServicesFromFile(line).equals("serviceName")) {
                    continue;
                }
                result.add(getNameServicesFromFile(line));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        result.descendingSet();
        return result;
    }

}