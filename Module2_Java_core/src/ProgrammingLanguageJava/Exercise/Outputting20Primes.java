package ProgrammingLanguageJava.Exercise;

import java.util.Scanner;

public class Outputting20Primes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of primes: ");
        int numbers = scanner.nextInt();
        int count = 0;

        for (int n = 2; count < numbers; n++) {
            boolean isPrime = true;
            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
                System.out.print(n + "\t");
            }
        }
    }
}