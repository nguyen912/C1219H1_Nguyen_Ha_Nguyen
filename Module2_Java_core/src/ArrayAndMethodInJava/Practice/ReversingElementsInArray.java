package ArrayAndMethodInJava.Practice;

import java.util.Scanner;

public class ReversingElementsInArray { Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReversingElementsInArray reversedArray = new ReversingElementsInArray();

        int[] numbers = new int[9];
        reversedArray.inputArray(numbers);
        System.out.print("Numbers: ");
        reversedArray.outputArray(numbers);

        reversedArray.reverse(numbers);

        System.out.println();
        System.out.print("Numbers after reversing: ");
        reversedArray.outputArray(numbers);
    }

    public void inputArray (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }
    }

    public void outputArray (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void reverse (int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        for (;i <= arr.length/2; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
}
