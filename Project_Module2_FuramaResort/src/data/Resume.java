package data;

import commons.FuncGeneric;
import models.Employee;

import java.util.ArrayList;
import java.util.Stack;

public class Resume {
    public Resume() {
    }

    public static Stack<Employee> getAllEmployees() {
        Stack<Employee> employeeList = new Stack<>();
        ArrayList<Employee> employeeArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.EMPLOYEE);
        for (Employee employee : employeeArrayList) {
            employeeList.push(employee);
        }

        return employeeList;
    }

}
