package ArrayAndMethodInJava.Practice;

import java.util.Scanner;

public class ReversingElementsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[9];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter element " + (i+1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }

        int i = 0;
        int j = numbers.length - 1;
        for (;i <= numbers.length/2; i++, j--) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

        }

        System.out.println();
        System.out.print("Numbers after reversing: ");
        for (i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }
}
