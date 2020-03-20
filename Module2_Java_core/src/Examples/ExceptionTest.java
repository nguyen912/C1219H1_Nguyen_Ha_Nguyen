package Examples;

import java.util.Scanner;

public class ExceptionTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean checkNum = false;
        do {
            try {
                System.out.println("Enter a number: ");
                int n = scanner.nextInt();
                checkNum = true;
            } catch (Exception ex) {
                System.out.println("try again!");
            }
        }
        while (checkNum);
    }
}
//    public void checkNumber(int n) throws Exception {
//        if (n <= 0) {
//            throw new Exception("wrong");
//        }
//        else {
//
//        }
//    }
//    public void inputNumber() {
//        boolean checkNum = false;
//        while (checkNum) {
//            try {
//                System.out.println("Enter a number: ");
//                int n = scanner.nextInt();
//                checkNum = true;
//            }
//            catch (Exception ex) {
//                System.out.println("try again!");
//            }
//        }
//
//
//    }