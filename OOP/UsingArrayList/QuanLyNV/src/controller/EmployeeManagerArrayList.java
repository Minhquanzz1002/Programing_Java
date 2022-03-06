package controller;

import model.Employee;
import model.FullTimeEmployee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeManagerArrayList {
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public void addNewEmployee(Employee newEmployee) {
        employeeArrayList.add(newEmployee);
    }

    public void deleteByIndex(Employee employee) {
        employeeArrayList.remove(employee);
    }

    public void updateByIndex(int index, Employee employee) {
        employeeArrayList.set(index, employee);
    }

    public double getAverage() {
        double sum = 0;
        for (Employee e : employeeArrayList) {
            sum += e.getSalary();
        }
        return sum / employeeArrayList.size();
    }

    /**
     * Danh sach nhan vien co muc luong thap hon muc luong trung binh toan cong ty
     * @return danh sach nhan vien
     */
    public ArrayList<Employee> getEmployeeLower() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee && e.getSalary() < getAverage()) {
                employees.add(e);
            }
        }
        return employees;
    }

    public void showAllEmployee() {
        for (Employee e : employeeArrayList) {
            System.out.println(e.toString());
        }
    }

    public void sortBySalary() {
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() > o2.getSalary() ? 1 : -1;
            }
        };
//        employeeArrayList.sort(employeeComparator);     // nhu nhau
        Collections.sort(employeeArrayList, employeeComparator);
    }


    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }
}
