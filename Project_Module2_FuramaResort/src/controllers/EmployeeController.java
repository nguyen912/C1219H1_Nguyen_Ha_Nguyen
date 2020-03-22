package controllers;

import commons.FuncGeneric;
import models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    }
}