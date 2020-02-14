package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class AddingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];

        System.out.println("Enter value: ");
        int n = scanner.nextInt();
        System.out.println("Enter index: ");
        int x = scanner.nextInt();

        for (int i = 0; i < numbers.length; i++) {
            if (x == i) {
                numbers[x] = n;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }
}
