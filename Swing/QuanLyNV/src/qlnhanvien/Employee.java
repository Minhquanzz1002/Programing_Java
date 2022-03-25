package qlnhanvien;

import java.io.Serializable;

public class Employee implements Serializable {
    private String empID, firstname, lastname, sex;
    private int age;
    private double salary;

    public Employee(){
    }

    public Employee(String empID, String firstname, String lastname, String sex, int age, double salary) {
        this.empID = empID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) throws Exception{
    	if (empID.isEmpty()) {
    		throw new Exception("Mã nhân viên không được để trống");
    	}
        this.empID = empID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) throws Exception{
    	if (firstname.isEmpty()) {
    		throw new Exception("Họ không được để trống");
    	}
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) throws Exception{
    	if (lastname.isEmpty()) {
    		throw new Exception("Tên không được để trống");
    	}
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws Exception{
    	if (lastname.isEmpty()) {
    		throw new Exception("Giới tính không được để trống");
    	}
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception{
    	if (age <= 0) {
    		throw new Exception("Tuổi phải lớn hơn 0");
    	}
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws Exception{
    	if(salary < 0) {
    		throw new Exception("Lương phải lớn hơn bằng không");
    	}
        this.salary = salary;
    }
}
