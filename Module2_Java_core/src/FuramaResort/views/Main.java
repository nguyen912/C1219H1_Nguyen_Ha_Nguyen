package FuramaResort.views;

import FuramaResort.controllers.MainController;
import FuramaResort.models.Services;
import FuramaResort.models.Villa;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            MainController.displayMainMenu();
            scanner.nextLine();
        }
    }
}
