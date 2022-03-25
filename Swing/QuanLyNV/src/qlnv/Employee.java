package qlnv;

import java.io.Serializable;

public class Employee implements Serializable{
	private String empID, firstName, lastName, sex;
	private int age;
	private double salary;
	public Employee(String empID, String firstName, String lastName, String sex, int age, double salary) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws Exception{
		if (firstName.isEmpty()) {
			throw new Exception("Họ không được để trống");
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws Exception{
		if (lastName.isEmpty()) {
			throw new Exception("Tên không được để trống");
		}
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) throws Exception{
		
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception{
		if (age <= 0) {
			throw new Exception("Tuổi không được nhỏ hơn bằng không");
		}
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) throws Exception{
		if (salary < 0) {
			throw new Exception("Lương phải lớn hơn bằng không");
		}
		this.salary = salary;
	}
	
}
