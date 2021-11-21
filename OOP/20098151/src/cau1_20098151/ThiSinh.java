package cau1_20098151;

import java.util.Scanner;

public class ThiSinh {
    private int sbd;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;
    private Khoi khoi;

    public ThiSinh() {
        khoi = new Khoi();
    }

    public ThiSinh(int sbd, String hoTen, String diaChi, int mucUuTien, Khoi khoi) {
        this.sbd = sbd;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
        this.khoi = khoi;
    }

    public int getSbd() {
        return sbd;
    }

    public void setSbd(int sbd) {
        this.sbd = sbd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    public boolean setMucUuTien(int mucUuTien) {
        if (mucUuTien > 0 && mucUuTien <= 3){
            this.mucUuTien = mucUuTien;
            return true;
        }
        System.out.print("Nhap sai muc do uu tien. Hay nhap lai [1,3]: ");
        return false;
    }

    public Khoi getKhoi() {
        return khoi;
    }

    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }

    public void nhapThiSinh(Scanner sc){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Nhap SBD: ");
        this.sbd = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten thi sinh: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap muc do uu tien [1,3]: ");
        while(!setMucUuTien(Integer.parseInt(sc.nextLine())));  
        khoi.nhapKhoi(sc);
    }

    public void hienThiThiSinh(){
        System.out.printf("%10d|%30s|%20s|%15d|",sbd, hoTen, diaChi, mucUuTien);
        System.out.println(khoi.getTenKhoi());
    }

    
}
