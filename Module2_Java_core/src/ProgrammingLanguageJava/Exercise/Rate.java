package ProgrammingLanguageJava.Exercise;

import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your dollar: ");
        int dollar = scanner.nextInt();
        int vnd = 23000;
        int usd = vnd * dollar;

        System.out.println(dollar + "USD = " +usd + "VND");
    }
}
