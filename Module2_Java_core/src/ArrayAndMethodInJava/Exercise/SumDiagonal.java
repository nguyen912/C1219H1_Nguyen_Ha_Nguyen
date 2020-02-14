package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class SumDiagonal {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SumDiagonal sumDiagonal = new SumDiagonal();

        System.out.println("Enter the number of rows and columns: ");
        int x = scanner.nextInt();

        int[][] matrix = new int[x][x];

        System.out.println("Enter elements of 2D array: ");
        sumDiagonal.input2DArray(matrix,x);

        System.out.println("Matrix: ");
        sumDiagonal.output2DArray(matrix,x);

        System.out.println("Matrix diagonal sum is: " + sumDiagonal.calculateSumDiagonal(matrix,x));
    }

    public void input2DArray (int arr[][], int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.println("Enter element at row " + (i+1) + ", column " + (j+1));
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public void output2DArray (int arr[][], int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int calculateSumDiagonal (int arr[][], int len) {
        int sum = 0;
        for (int i = 0, j = 0; i < len; i++, j++) {
                sum += arr[i][j];
        }
        return sum;
    }
}
