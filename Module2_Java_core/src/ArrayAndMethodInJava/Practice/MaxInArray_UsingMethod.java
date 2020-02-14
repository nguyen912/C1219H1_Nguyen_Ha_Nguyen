package ArrayAndMethodInJava.Practice;

public class MaxInArray_UsingMethod {
    public static void main(String[] args) {
        int[] numbers = {3,6,9,7,1,0};
        minValue(numbers);
    }
    public static void minValue (int n[]) {
        int min = n[0];
        int index = 0;
        for (int i = 1; i < n.length; i++) {
            if (min > n[i]) {
                min = n[i];
                index = i;
            }
        }
        System.out.println("The smallest element in the array is: " + min + ", at position " + index);
    }
}
