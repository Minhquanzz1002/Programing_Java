package cau1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class DanhSachSinhVien {
    private Vector<SinhVien> listSV = new Vector<>();
   
    public boolean ktTrungma(String masv) {
        int size = listSV.size();
        for (int i = 0; i < size; i++) {
            if (listSV.get(i).getMasv().equalsIgnoreCase(masv)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSinhvien(SinhVien sv) {
        if (ktTrungma(sv.getMasv())){
            return false;
        }
        return listSV.add(sv);
    }

    public SinhVien findSinhvien1(String masv) {
        for (SinhVien sv : listSV) {
            if (sv.getMasv().equalsIgnoreCase(masv))
                return sv;
        }
        return null;
    }

    public int findSinhvien2(String masv) {
        int size = listSV.size();
        for (int i = 0; i < size; i++) {
            if (listSV.get(i).getMasv().equalsIgnoreCase(masv))
                return i;
        }
        return -1;
    }

    public SinhVien updateSinhvien(int index, SinhVien sv) {
        return listSV.set(index, sv);
    }

    public void removeSinhvien(String masv) {
        SinhVien sv = findSinhvien1(masv);
        listSV.remove(sv);
    }

    public void sortAscendingByID() {
        Collections.sort(listSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMasv().compareTo(o2.getMasv());
            }
        });
    }
    
    public String toString() {
        return listSV.toString();
    }
}
