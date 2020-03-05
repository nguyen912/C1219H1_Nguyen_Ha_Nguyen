package FuramaResort.commons;

import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveListServices(ArrayList<Villa>villas, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter
                    (fileOutputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Villa villa : villas) {
                String line = villa.getId() + ";" + villa.getServiceName() + ";" + villa.getCost();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            fileOutputStream.close();
            outputStreamWriter.close();
            bufferedWriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
