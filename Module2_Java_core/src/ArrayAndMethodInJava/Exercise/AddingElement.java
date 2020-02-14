package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class AddingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declare 1D array has 10 elements
        int[] numbers = new int[10];

        //Declare x is index, n is value
        int x;
        int n;

        // Add elements of numbers (1D array) with index and value by scanning.
        // Loop is outing if you scan x >= numbers.length
        do {
            System.out.println("Enter index: ");
            x = scanner.nextInt();
            System.out.println("Enter value: ");
            n = scanner.nextInt();

            for (int i = 0; i < numbers.length; i++) {
                if (x == i) {
                    numbers[x] = n;
                }
            }
        }
        while (x < numbers.length);

        //Display numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }
}
