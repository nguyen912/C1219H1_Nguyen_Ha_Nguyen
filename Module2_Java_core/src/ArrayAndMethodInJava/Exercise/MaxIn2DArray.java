package ArrayAndMethodInJava.Exercise;

import java.util.Calendar;
import java.util.Scanner;

public class MaxIn2DArray {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Enter the number of rows and columns
        System.out.println("Enter the number of rows: ");
        int x = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int y = scanner.nextInt();

        //Declare 2D array
        double[][] numbers = new double[x][y];

        //Enter elements of 2D array
        System.out.println("Enter elements: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println("Enter row " + (i + 1) + " column " + (j + 1));
                numbers[i][j] = scanner.nextDouble();
            }
        }

        //Display 2D array
        System.out.println("2D array: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }

        //Declare max is the first value in row 0 column 0
        double max = numbers[0][0];

        int indexRow = 0;
        int indexColumn = 0;

        //Find max
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (max < numbers[i][j]) {
                    max = numbers[i][j];
                    indexRow = i;
                    indexColumn = j;
                }
            }
        }

        //Display max
        System.out.println("Max is: " + max + ", at row " + (indexRow + 1) + " column " + (indexColumn + 1));

    }
}