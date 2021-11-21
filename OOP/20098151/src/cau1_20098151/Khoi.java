package cau1_20098151;

import java.util.Scanner;

public class Khoi {
    private String tenKhoi;
    private String[] mon;
    
    public Khoi() {
    }

    public Khoi(String tenKhoi, String[] mon) {
        this.tenKhoi = tenKhoi;
        this.mon = mon;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public boolean setTenKhoi(String tenKhoi) {
        if (tenKhoi.equals("A") || tenKhoi.equals("B") || tenKhoi.equals("C")) {
            this.tenKhoi = tenKhoi;
            return true;
        } else {
            System.out.print("Nhap lai ten khoi (A, B, C): ");
            return false;
        }
    }

    public String[] getMon() {
        return mon;
    }

    public void setMon(String[] mon) {
        this.mon = mon;
    }

    public void nhapKhoi(Scanner sc) {
        System.out.print("Nhap ten khoi: ");
        while (!setTenKhoi(sc.nextLine()))
            ;
        if (this.tenKhoi.equals("A")) {
            String mon[] = { "Toan", "Ly", "Hoa" };
            this.mon = mon;
        } else if (this.tenKhoi.equals("B")) {
            String mon[] = { "Toan", "Hoa", "Sinh" };
            this.mon = mon;
        } else {
            String mon[] = { "Van", "Su", "Dia" };
            this.mon = mon;
        }
    }
}
