package cau1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien {
    public static Scanner sc  = new Scanner(System.in);
    private String Masv;
    private String Tensv;
    private Date Namsinh;
    private String Diachi;
    private String Lop;

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String masv) {
        Masv = masv;
    }

    public String getTensv() {
        return Tensv;
    }

    public void setTensv(String tensv) {
        Tensv = tensv;
    }

    public Date getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(Date namsinh) {
        Namsinh = namsinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String toString() {
        return "Sinhvien [Masv=" + Masv + ", Tensv=" + Tensv + ", Namsinh="
                + Namsinh + ", Diachi=" + Diachi + ", Lop=" + Lop + "]\n";
        
    }

    public Date convertStringToDate(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date convert_dob = null;
        try {
            convert_dob = sdf.parse(dob);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convert_dob;
    }

    public void nhapSinhVien() {
        System.out.println("------------------------------------------------------------------");
        System.out.print("Nhap ma SV: ");
        this.Masv = sc.nextLine();
        System.out.print("Nhap ten SV: ");
        this.Tensv = sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        this.Namsinh = convertStringToDate(sc.nextLine());
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
        System.out.print("Nhap lop: ");
        this.Lop = sc.nextLine();
    }

}
