package controllers;

import commons.FuncGeneric;
import commons.ScannerUtils;
import data.Resume;
import models.Employee;

import java.util.*;

import static controllers.MainController.backMainMenu;

public class EmployeeController {
    public static void showInfoEmployee() {
        ArrayList<Employee> employeeList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.EMPLOYEE);
        Map<String, Employee> map = new HashMap<>();
        for (Employee employee : employeeList) {
            map.put(employee.getId(), employee);
        }
        displayMap(map);
        backMainMenu();
    }

    public static void displayMap(Map<String, Employee> map) {
        for (Map.Entry m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + "\n" + m.getValue().toString());
        }
    }

    public static void findEmployeeFromResume() {
        Stack<Employee> employeeStack = Resume.getAllEmployees();
        System.out.println("Enter key of employee: ");
        String inputSearch = ScannerUtils.scanner.nextLine();
        try {
            while (true) {
                boolean foundById = employeeStack.peek().getId().contains(inputSearch);
                if (!foundById) {
                    employeeStack.pop();
                }
                else {
                    System.out.println("Founded employee below.");
                    System.out.println(employeeStack.peek().toString());
                    break;
                }
            }
        }
        catch (EmptyStackException e) {
            System.out.println("Key invalid. Please try again!");
            findEmployeeFromResume();
        }
        backMainMenu();
    }
}