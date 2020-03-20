package views;

import case_study.FuramaResort.controllers.MainController;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            MainController.displayMainMenu();
            System.out.println("Successful!");
            scanner.nextLine();
        }
    }
}
