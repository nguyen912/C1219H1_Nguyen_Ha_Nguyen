package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class DeletingElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeletingElementInArray element = new DeletingElementInArray();

        int numbers[] = {0,1,2,3,4,5,6,7,8,9};
        int size = numbers.length;

        System.out.println("Enter the index: ");
        int x = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            if (x == i) {
                for (int j = i; j < size-1; j++) {
                    numbers[j] = numbers[j+1];
                }
                numbers[size-1] = 0;
                break;
            }
        }

        System.out.println("Array after deleting a element: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }
}
