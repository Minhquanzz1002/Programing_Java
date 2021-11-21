package cau2_20098151;

import java.util.Scanner;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String queQuan;
    private String maGV;

    public Nguoi() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean setHoTen(String hoTen) {
        if (hoTen == null || hoTen.isEmpty() || hoTen.matches("\\s+")){
            System.out.print("Ten khong duoc rong. Hay nhap lai: ");
            return false;
        }
        this.hoTen = hoTen;
        return true;
    }

    public int getTuoi() {
        return tuoi;
    }

    public boolean setTuoi(int tuoi) {
        if (tuoi > 0) {
            this.tuoi = tuoi;
            return true;
        }
        System.out.print("Nhap sai. Hay nhap lai (tuoi > 0): ");
        return false;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void themNguoi(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        while(!setHoTen(sc.nextLine()));
        System.out.print("Nhap tuoi: ");
        while(!setTuoi(Integer.parseInt(sc.nextLine())));
        System.out.print("Nhap que quan: ");
        this.queQuan = sc.nextLine();
        System.out.print("Nhap ma giang vien: ");
        this.maGV = sc.nextLine();
    }

    public void inNguoi() {
        System.out.printf("%30s|%10d|%20s|%10s|", hoTen, tuoi, queQuan, maGV);
    }
}
