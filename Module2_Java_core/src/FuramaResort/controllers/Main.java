package FuramaResort.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
