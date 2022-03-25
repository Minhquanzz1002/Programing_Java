package qlnhanvien;

import java.io.Serializable;
import java.util.ArrayList;

public class ListEmployee implements Serializable {
    ArrayList<Employee> lstEmp;

    public ListEmployee() {
        lstEmp = new ArrayList<>();
    }

    public ArrayList<Employee> getLstEmp() {
        return lstEmp;
    }

    public void setLstEmp(ArrayList<Employee> lstEmp) {
        this.lstEmp = lstEmp;
    }

    public boolean addEmployee(Employee e){
        if (lstEmp.contains(e)){
            return false;
        }
        lstEmp.add(e);
        return true;
    }

    public boolean deleteEmployee(Employee e){
        if (lstEmp.contains(e)){
            lstEmp.remove(e);
            return true;
        }
        return false;
    }
}
