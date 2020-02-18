package ClassAndObjectInJava.Exercise.StopWatch;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Random random = new Random();
        long[] numbers = new long[10000];
        int size = numbers.length;

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < size-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    long temp = numbers[minIndex];
                    numbers[minIndex] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + "\t");
        }

        System.out.println();
        stopWatch.stop();
        System.out.println("Process time: " + stopWatch.getElapsedTime());
    }
}
