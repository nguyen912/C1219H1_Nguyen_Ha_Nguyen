package ArrayAndMethodInJava.Practice;

public class Swapping {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int[] numbers = new int[2];
        numbers[0] = a;
        numbers[1] = b;
        swap(numbers);
        System.out.println("a = " + numbers[0] + ", b = " + numbers[1]);
    }

    public static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}
