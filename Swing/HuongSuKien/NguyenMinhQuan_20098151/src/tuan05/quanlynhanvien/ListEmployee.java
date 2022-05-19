package tuan05.quanlynhanvien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ListEmployee implements Serializable {
	ArrayList<Employee> lstEmployee;

	public ListEmployee() {
		lstEmployee = new ArrayList<>();
	}
	
	public ListEmployee(ArrayList<Employee> lstEmployee) {
		super();
		this.lstEmployee = lstEmployee;
	}

	public ArrayList<Employee> getLstEmployee() {
		return lstEmployee;
	}

	public void setLstEmployee(ArrayList<Employee> lstEmployee) {
		this.lstEmployee = lstEmployee;
	}

	public boolean addEmployee(Employee item) {
		for (Employee e : lstEmployee) {
			if (item.getEmployeeID().equalsIgnoreCase(e.getEmployeeID())) {
				return false;
			}
		}
		/* Kiểm tra nhân viên có tồn tại trong danh sách chưa */
		if (lstEmployee.contains(item)) {
			return false;
		}
		lstEmployee.add(item);
		return true;
	}

	public boolean updateEmployee(Employee emp, Employee empNew) {
		int index = lstEmployee.indexOf(emp);
		if (index != -1) {
			lstEmployee.set(index, empNew);
			return true;
		}
		return false;
	}

	public boolean deleteEmployee(Employee item) {
		if (lstEmployee.contains(item)) {
			lstEmployee.remove(item);
			return true;
		}
		return false;
	}

	public int sizeListEmployee() {
		return lstEmployee.size();
	}

	public int searchEmployee(String id) {
		for (Employee employee : lstEmployee) {
			if (employee.getEmployeeID().equalsIgnoreCase(id)) {
				return lstEmployee.indexOf(employee);
			}
		}
		return -1;
	}
}
