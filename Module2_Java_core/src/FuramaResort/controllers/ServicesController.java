package FuramaResort.controllers;

import FuramaResort.commons.FileManager;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicesController {
    public void addNewVilla() {
        ArrayList<Villa> villas = new ArrayList<Villa>();
        villas.add(new Villa("v001", "paradise villa", 800, 500,
                10, "day", "5 stars",
                "swimming pool, massage", 50, 3));
        villas.add(new Villa("v002", "rude villa", 600, 400,
                10, "day", "5 stars",
                "view tiger", 50, 2));

        FileManager.saveListServices(villas, "d:\\services.csv");

    }
}
