package FuramaResort.commons;

import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.lang.Double;

public class FileManager {
    //Write File CSV
    //*******************************************************************************************
    private static String generalServiceHeader = "ID" + "," + "SERVICE NAME" + "," + "AREA" + ","
            + "COST" + "," + "MAX PEOPLE" + "," + "RENTED TYPE";
    private static String houseOnlyHeader = "," + "ROOM STANDARD" + "," + "OTHER FACILITIES" + ","
            + "THE NUMBER OF FLOORS";
    private static String villaOnlyHeader = "," + "SWIMMING POOL AREA";
    private static String roomOnlyHeader = "," + "FREE SERVICE";

    public static boolean writeFileCSVVilla(ArrayList<Villa> villas, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);


            bw.write(generalServiceHeader + houseOnlyHeader + villaOnlyHeader);
            bw.newLine();

            for (Villa villa : villas) {
                bw.write(writeGeneralServiceDetail(villa) + writeOnlyHouseDetail(villa) + ","
                        + villa.getPoolArea());
                bw.newLine();
            }

            bw.close();
            osw.close();
            fos.close();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean writeFileCSVHouse (ArrayList<House>houses, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(generalServiceHeader + houseOnlyHeader);
            bw.newLine();

            for (House house : houses) {
                bw.write(writeGeneralServiceDetail(house) + writeOnlyHouseDetail(house));
                bw.newLine();
            }

            bw.close();
            osw.close();
            fos.close();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean writeFileCSVRoom(ArrayList<Room>rooms, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(generalServiceHeader + roomOnlyHeader);
            bw.newLine();

            for (Room room : rooms) {
                bw.write(writeGeneralServiceDetail(room) + "," + room.getFreeService());
                bw.newLine();
            }

            bw.close();
            osw.close();
            fos.close();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static String writeGeneralServiceDetail(Services services) {
        String serviceDetail = services.getId() + "," + services.getServiceName() + "," + services.getUsedArea() +
                "," + services.getCost() + "," + services.getMaxPerson() + "," + services.getRentedType();
        return serviceDetail;
    }
    private static String writeOnlyHouseDetail(Services house) {
        String houseOnlyDetail = "," + ((House)house).getRoomStandard() + "," + ((House)house).getOtherFacility() +
                "," + ((House)house).getFloor();
        return houseOnlyDetail;
    }
    //*******************************************************************************************

    //Read File CSV
    //*******************************************************************************************
    public static ArrayList<Villa> readFileCSVVilla(String path) {
        ArrayList<Villa>villas = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr.length == 10) {
                    Villa villa = new Villa(arr[0], arr[1], Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5],
                            arr[6], arr[7], Integer.parseInt(arr[8]), Double.parseDouble(arr[9]));
                    villas.add(villa);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return villas;
    }

    public static ArrayList<House> readFileCSVHouse(String path) {
        ArrayList<House>houses = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr.length == 9) {
                    House house = new House(arr[0], arr[1], Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5],
                            arr[6], arr[7], Integer.parseInt(arr[8]));
                    houses.add(house);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return houses;
    }

    public static ArrayList<Room> readFileCSVRoom(String path) {
        ArrayList<Room>rooms = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr.length == 7) {
                        Room room = new Room(arr[0], arr[1], Double.parseDouble(arr[2]),
                                Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5],
                                arr[6]);
                        rooms.add(room);
                }


                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return rooms;
    }
    //*******************************************************************************************

}
