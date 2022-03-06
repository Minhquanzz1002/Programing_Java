package cau1;

public class TestSinhVien {
    public static void main(String[] args) {
        DanhSachSinhVien qlSV = new DanhSachSinhVien();
        SinhVien[] sv = new SinhVien[2];
        sv[0] = new SinhVien();
        sv[1] = new SinhVien();
        sv[0].nhapSinhVien();
        sv[1].nhapSinhVien();
        qlSV.addSinhvien(sv[0]);
        qlSV.addSinhvien(sv[1]);
        System.out.println(qlSV);
        qlSV.sortAscendingByID();
        System.out.println("Dach sach sap xep tang");
        System.out.println(qlSV);
    }
}
