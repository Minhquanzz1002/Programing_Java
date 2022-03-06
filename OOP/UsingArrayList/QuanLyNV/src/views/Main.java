package views;

import controller.EmployeeManagerArrayList;
import model.Employee;
import model.FullTimeEmployee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeManagerArrayList e = new EmployeeManagerArrayList();
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new FullTimeEmployee(1, 1000, 1000));
        employeeArrayList.add(new FullTimeEmployee(1, 1000, 1002));
        employeeArrayList.add(new FullTimeEmployee(1, 1000, 1001));
        e.setEmployeeArrayList(employeeArrayList);
        e.showAllEmployee();
        e.sortBySalary();
        e.showAllEmployee();
    }

}
