package FuramaResort.commons;

import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void writeFileCSV(ArrayList<Services> services, String serviceName, String path) {
        Villa villa = new Villa();
        House house = new House();
        Room room = new Room();

        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            String serviceColumnName = "ID" + "," + "NAME" + "," + "AREA" + "," + "COST" + "," + "MAX PEOPLE" + "," + "RENTED TYPE";
            String houseOnlyColumnName = "," + "ROOM STANDARD" + "," + "OTHER FACILITIES" + "," + "THE NUMBER OF FLOORS";
            String villaOnlyColumnName = "," + "SWIMMING POOL AREA";
            String roomOnlyColumnName = "," + "FREE SERVICE";

            if (serviceName.equals("villa")) {
                bw.write(serviceColumnName + houseOnlyColumnName + villaOnlyColumnName);
                bw.newLine();

                for (Services v : services) {
                    bw.write(writeGeneralServiceDetail(v) + writeOnlyHouseDetail(v) + "," + ((Villa)villa).getPoolArea());
                    bw.newLine();
                }
                System.out.println("Save villa detail successfully!");
            }
            else if (serviceName.equals("house")) {
                bw.write(serviceColumnName + houseOnlyColumnName);
                bw.newLine();
                for (Services h : services) {
                    bw.write(writeGeneralServiceDetail(h) + writeOnlyHouseDetail(h));
                    bw.newLine();
                }
                System.out.println("Save house detail successfully!");
            }
            else {
                bw.write(serviceColumnName + "," + roomOnlyColumnName);
                bw.newLine();
                for (Services r : services) {
                    bw.write(writeGeneralServiceDetail(r) + "," + ((Room)room).getFreeService());
                    bw.newLine();
                }
                System.out.println("Save room detail successfully!");
            }

            bw.close();
            osw.close();
            fos.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public static ArrayList<Services> readFileCSV(String serviceName, String path) {
        ArrayList<Services>services = new ArrayList<>();
        ArrayList<Services>villas = new ArrayList<>();
        ArrayList<Services>houses = new ArrayList<>();
        ArrayList<Services>rooms = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            if (serviceName.equals("villa")) {
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
                return villas;
            }
            else if (serviceName.equals("house")) {
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
                return houses;
            }
            else {
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
                return rooms;
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }
}

