package NgonNguLapTrinhJava.Practice;

import java.util.Scanner;

public class ApplicationForCalculatingLoanInterests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your money: ");
        int money = scanner.nextInt();
        System.out.println("Enter saving term: ");
        byte term = scanner.nextByte();
        System.out.println("Enter interest loan: ");
        double interestLoan = scanner.nextFloat();

        for (byte i = 1; i <= term; i++) {
            int totalInterest = (int) (money * (interestLoan / 12) * i);
            System.out.println("Savings deposit after " + i + " month: " + totalInterest + " VND.");
        }
    }
}
