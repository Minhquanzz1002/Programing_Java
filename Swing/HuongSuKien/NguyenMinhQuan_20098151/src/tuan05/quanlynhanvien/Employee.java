package tuan05.quanlynhanvien;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
	private String employeeID, firstName, lastName, sex;
	private int age;
	private double salary;

	public Employee(String employeeID, String firstName, String lastName, String sex, int age, double salary) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.salary = salary;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) throws Exception {
		if (employeeID.isEmpty()) {
			throw new Exception("Mã nhân viên không được để trống");
		}
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if (firstName.isEmpty()) {
			throw new Exception("Họ không được để trống");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if (lastName.isEmpty()) {
			throw new Exception("Tên không được để trống");
		}
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) throws Exception {
		if (sex.isEmpty()) {
			throw new Exception("Giới tính không được để trống");
		}
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		if (age <= 0) {
			throw new Exception("Tuổi phải lớn hơn 0");
		}
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if (salary <= 0) {
			throw new Exception("Lương phải lớn hơn 0");
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", sex="
				+ sex + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, employeeID, firstName, lastName, salary, sex);
	}
}
