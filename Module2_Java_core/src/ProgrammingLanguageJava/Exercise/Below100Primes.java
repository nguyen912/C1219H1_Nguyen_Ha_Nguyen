package ProgrammingLanguageJava.Exercise;

public class Below100Primes {
    public static void main(String[] args) {
        System.out.println("Primes below 100: ");
        for (int number = 2; number <= 100; number++) {
            boolean isPrime = true;
            for (int n = 2; n <= number / 2; n++) {
                if (number % n == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.print(number + "\t");
            }
        }
    }
}
