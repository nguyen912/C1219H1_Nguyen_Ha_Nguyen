package ArrayAndMethodInJava.Exercise;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of columns: ");
        int col = scanner.nextInt();

        int[][] matrix = new int[3][col];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Row " + (i+1) + " column " + (j+1));
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Which column you want to choose?");
        int chooseColumn = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < col; j++) {
                if (chooseColumn == (j+1)) {
                    sum += matrix[i][j];
                }
            }
        }

        System.out.println("Sum of column " + chooseColumn + " is " + sum);
    }
}
