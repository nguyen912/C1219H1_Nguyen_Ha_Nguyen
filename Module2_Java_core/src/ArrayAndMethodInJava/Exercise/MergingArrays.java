package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class MergingArrays {
    Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declare Object mergingArrays
        MergingArrays mergingArrays = new MergingArrays();

        //Enter the number of array1 and array2's elements
        System.out.println("Enter the number of elements in array 1: ");
        int a = scanner.nextInt();
        System.out.println("Enter the number of elements in array 2: ");
        int b = scanner.nextInt();

        //Declare arrays
        int[] array1 = new int[a];
        int[] array2 = new int[b];
        int[] array3 = new int[a+b];

        //Enter elements of array1 and array2
        mergingArrays.inputArrays(array1,a,1);
        mergingArrays.inputArrays(array2,b,2);

        //Display array1 and array2
        mergingArrays.outputArrays(array1,a,1);
        System.out.println();
        mergingArrays.outputArrays(array2,b,2);

        //Enter elements of array3 from array1 and array2
        System.out.println();
        System.out.println("Enter elements in array 3: ");
        for (int i = 0, j = 0; i < a; i++, j++) {
                array3[i] = array1[j];
        }
        for (int i = a, k = 0; i < a+b; i++, k++) {
                array3[i] = array2[k];
        }

        //Display array3
        mergingArrays.outputArrays(array3,a+b,3);
    }

    public void inputArrays (int arr[], int len, int n) {
        System.out.println("Enter elements in array " + n + ": ");
        for (int i = 0; i < len; i++) {
            System.out.println("Element " + (i+1));
            arr[i] = scanner.nextInt();
        }
    }

    public void outputArrays (int arr[], int len, int n) {
        System.out.println("Array " + n + ": ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
