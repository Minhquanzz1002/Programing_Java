package cau2_20098151;

import java.util.Scanner;

public class CBGV {
    private Nguoi canBo;
    private int luongCung;
    private int luongThuong;
    private int tienPhat;
    private int luongThucLinh;

    public CBGV() {
        canBo = new Nguoi();
    }

    public int getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(int luongCung) {
        this.luongCung = luongCung;
    }

    public int getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(int luongThuong) {
        this.luongThuong = luongThuong;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getLuongThucLinh() {
        return luongThucLinh;
    }

    public void setLuongThucLinh(int luongThucLinh) {
        this.luongThucLinh = luongThucLinh;
    }

    public Nguoi getCanBo() {
        return canBo;
    }

    public void setCanBo(Nguoi canBo) {
        this.canBo = canBo;
    }

    public void tinhLuongThucLinh() {
        this.luongThucLinh = this.luongCung + this.luongThuong - this.tienPhat;
    }

    public void themCBGV(Scanner sc){
        System.out.println("-----------------------------------------------------------------------------------");
        canBo.themNguoi(sc);
        System.out.print("Nhap luong cung: ");
        this.luongCung = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap luong thuong: ");
        this.luongThuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap tien phat: ");
        this.tienPhat = Integer.parseInt(sc.nextLine());
        tinhLuongThucLinh();
    }

    public void hienthiCBGV(){
        canBo.inNguoi();
        System.out.printf("%15d|%15d|%15d|%15d\n",luongCung, luongThuong, tienPhat, luongThucLinh);
    }
}
