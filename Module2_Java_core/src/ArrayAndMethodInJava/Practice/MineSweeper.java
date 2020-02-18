package ArrayAndMethodInJava.Practice;

import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] mine = {{"*",".",".","."},{".",".",".","."},{".","*",".","."},{".",".",".","."}};

        for (int i = 0; i < mine.length; i++) {
            for (int j = 0; j < mine[i].length; j++) {
                System.out.print(mine[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < mine.length; i++) {
            boolean checkStar = false;
            for (int j = 0; j < mine[i].length; j++) {
                if (mine[i][j].equals("*")) {
                    System.out.print("*");
                    checkStar = true;
                }
                else {
                    if (checkStar) {
                        System.out.print("1");
                    }
                }
            }
        }
    }
}
