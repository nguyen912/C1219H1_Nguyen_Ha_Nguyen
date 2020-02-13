package ProgrammingLanguageJava.Exercise;

import java.util.Scanner;

public class ConvertingNumberToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scan.nextInt();

        if (number >= 0 && number < 10) {
            covertBelow10Number(number);
        }
        else if (number < 100){
            convertBelow100Number(number);
        }
        else {
            if (number > 999) {
                System.out.println("out of ability");
            }
            else {
                int hundreds = number / 100;
                int surplus = number % 100;
                covertBelow10Number(hundreds);
                System.out.print(" hundred");
                //System.out.println(surplus);
                if (surplus != 0) {
                    System.out.print(" and ");
                    if (surplus < 10) {
                        covertBelow10Number(surplus);
                    }
                    else {
                        convertBelow100Number(surplus);
                    }
                }
            }
        }
    }
    public static void covertBelow10Number(int number) {
        switch (number) {
            case 0:
                System.out.print("zero");
                break;
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            case 4:
                System.out.print("four");
                break;
            case 5:
                System.out.print("five");
                break;
            case 6:
                System.out.print("six");
                break;
            case 7:
                System.out.print("seven");
                break;
            case 8:
                System.out.print("eight");
                break;
            case 9:
                System.out.print("nine");
                break;
            default:
                System.out.print("out of ability");
        }
    }
    public static void convertBelow100Number(int number) {
        if (number < 20) {
            int ones = number % 10;
            if (ones >= 4 && ones != 5) {
                covertBelow10Number(ones);
                System.out.println("teen");
            }
            else {
                switch (ones) {
                    case 0:
                        System.out.print("ten");
                        break;
                    case 1:
                        System.out.print("eleven");
                        break;
                    case 2:
                        System.out.print("twelve");
                        break;
                    case 3:
                        System.out.print("thirteen");
                        break;
                    case 5:
                        System.out.print("fifteen");
                        break;
                }
            }
        }
        else if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            if (tens >= 4 && tens != 5) {
                covertBelow10Number(tens);
            }
            else {
                switch (tens) {
                    case 2:
                        System.out.print("twen");
                        break;
                    case 3:
                        System.out.print("thir");
                        break;
                    case 5:
                        System.out.print("fif");
                        break;
                }
            }
            System.out.print("ty ");
            if (ones > 0) {
                covertBelow10Number(ones);
            }
        }
    }
}
