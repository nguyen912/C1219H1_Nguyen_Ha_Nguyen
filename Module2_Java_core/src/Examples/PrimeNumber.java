package Examples;

import javax.crypto.spec.PSource;

public class PrimeNumber {
    public static void main(String[] args) {
        int countPrime = 0;
        for (int n = 500; n <= 5000; n++) {
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (n%i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(n);
                countPrime++;
            }
        }
        System.out.println("The number of primes: " + countPrime);
    }
}
