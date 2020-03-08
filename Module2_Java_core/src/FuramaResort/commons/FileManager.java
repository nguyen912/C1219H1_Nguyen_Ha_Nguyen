package FuramaResort.commons;

import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileManager {
    public static void writeFileCSV(ArrayList<Services>listService, String service, String path) {
        try {
            ArrayList<Villa> villas = new ArrayList<Villa>();
            ArrayList<Room> rooms = new ArrayList<Room>();
            ArrayList<House> houses = new ArrayList<House>();

            Services services = new Services() {
                @Override
                public String showInfo() {
                    return null;
                }
            };
            Services room = new Room();
            Services house = new House();
            Services villa = new Villa();

            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            String serviceColumnName = "ID" + "," + "NAME" + "," + "AREA" + "," + "COST" + "," + "MAX PEOPLE" +
                    "," + "RENTED TYPE";
            String houseOnlyColumnName = "," + "ROOM STANDARD" + "," + "OTHER FACILITIES" + "," +
                    "THE NUMBER OF FLOORS";

            String serviceDetail = services.getId() + "," + services.getServiceName() + "," + services.getUsedArea() +
                    "," + services.getCost() + "," + services.getMaxPerson() + "," + services.getRentedType();
            String houseOnlyDetail = "," + ((House)house).getRoomStandard() + "," + ((House)house).getOtherFacility() +
                    "," + ((House)house).getFloor();

            if (service.equals("room")) {
                String roomColumnName = serviceColumnName + "," + "FREE SERVICE";
                bw.write(roomColumnName);
                bw.newLine();

                for(Services r : listService) {
                    String roomDetail = serviceDetail + "," + ((Room) room).getFreeService();
                    bw.write(roomDetail);
                    bw.newLine();
                }

                bw.close();
                osw.close();
                fos.close();
            }

            else if (service.equals("villa")) {
                String villaColumnName = serviceColumnName + houseOnlyColumnName + "," + "POOL AREA";;
                bw.write(villaColumnName);
                bw.newLine();

                for (Services v : villas) {
                    String villaDetail = serviceDetail + houseOnlyDetail + "," + ((Villa)villa).getPoolArea();
                    bw.write(villaDetail);
                    bw.newLine();
                }

                bw.close();
                osw.close();
                fos.close();
            }
            else {
                String houseColumnName = serviceColumnName + houseOnlyColumnName;
                bw.write(houseColumnName);
                bw.newLine();

                for (House h : houses) {
                    String houseDetail = serviceDetail + houseOnlyDetail;
                    bw.write(houseDetail);
                    bw.newLine();
                }

                bw.close();
                osw.close();
                fos.close();
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
