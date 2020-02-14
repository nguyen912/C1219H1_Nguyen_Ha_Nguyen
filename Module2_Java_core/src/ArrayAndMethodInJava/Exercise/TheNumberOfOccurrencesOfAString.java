package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class TheNumberOfOccurrencesOfAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String myName = "Nguyen Ha Nguyen";
        int size = myName.length();
        int count = 0;

        System.out.println("Enter the character that you want to find: ");
        char c = scanner.next().charAt(0);

        for (int i = 0; i < size; i++) {
            if (myName.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("There is/are " + count + " in " + myName);
    }
}
