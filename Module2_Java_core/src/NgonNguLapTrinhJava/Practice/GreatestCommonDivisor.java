package NgonNguLapTrinhJava.Practice;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a:");
        int a = scanner.nextInt();
        System.out.println("Enter b:");
        int b = scanner.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        else {
            while (a != b) {
                if (a > b) {
                    a -= b;
                }
                else {
                    b -= a;
                }
            }
            System.out.println("The greatest common factor is : " + a);
        }

    }
}
