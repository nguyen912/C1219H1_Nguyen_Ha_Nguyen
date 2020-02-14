package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class MaxIn2DArray {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int x = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int y = scanner.nextInt();
        double[][] numbers = new double[x][y];

        MaxIn2DArray max2D = new MaxIn2DArray();
//        max2D.inputElements(numbers, x, y);
//        max2D.outputArray(numbers, x, y);

        System.out.println("Enter elements: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println("Enter row " + (i+1) + " column " + (j+1));
                numbers[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("2D array: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }

        double max = numbers[0][0];
        int indexRow = 0;
        int indexColumn = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (max < numbers[i][j]) {
                    max = numbers[i][j];
                    indexRow = i;
                    indexColumn = j;
                }
            }
        }
        System.out.println("Max is: " + max + ", at row " + (indexRow+1) + " column " + (indexColumn+1));

    }

//    public void inputElements (double arr[][], int a, int b) {
//        arr = new double[a][b];
//        System.out.println("Enter elements: ");
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                System.out.println("Enter row " + (i+1) + " column " + (j+1));
//                arr[i][j] = scanner.nextDouble();
//            }
//        }
//    }

//    public void outputArray (double arr[][], int a, int b) {
//        arr = new double[a][b];
//        System.out.println("2D array: ");
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
}
