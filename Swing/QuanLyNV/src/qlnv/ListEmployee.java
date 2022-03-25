package qlnv;

import java.io.Serializable;
import java.util.ArrayList;

public class ListEmployee implements Serializable{
	private ArrayList<Employee> lstEmp;

	public ListEmployee() {
		lstEmp = new ArrayList<>();
	}
	
	public ListEmployee(ArrayList<Employee> lstEmp) {
		super();
		this.lstEmp = lstEmp;
	}

	public ArrayList<Employee> getLstEmp() {
		return lstEmp;
	}

	public void setLstEmp(ArrayList<Employee> lstEmp) {
		this.lstEmp = lstEmp;
	}
	
	public boolean addEmployee(Employee emp) {
		if (lstEmp.contains(emp)) {
			return false;
		}
		lstEmp.add(emp);
		return true;
	}
}
