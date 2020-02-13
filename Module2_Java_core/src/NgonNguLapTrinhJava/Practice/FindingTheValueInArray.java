package NgonNguLapTrinhJava.Practice;

import java.util.Scanner;

public class FindingTheValueInArray {

        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Moi nhap ten hoc sinh muon tim:");
            String name = sc.next();
            String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya",
                    "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
            boolean isExist = false;
            for(int i = 0; i < students.length; i++) {
                if(students[i].equals(name)) {
                    System.out.println("Hoc sinh " + name + " nam o vi tri thu " + (i+1)
                            + " trong danh sach");
                    isExist = true;
                    break;
                }
            }
            if(!isExist) {
                System.out.println("Khong co hoc sinh ten " + name + " trong danh sach");
            }
        }
    }

