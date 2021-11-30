import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLNV {
    public static Scanner sc = new Scanner(System.in);
    private List<GiangVien> dsGiangVien;
    private List<NghienCuuVien> dsNghienCuuVien;
    private List<NhanVienVanPhong> dsNhanVienVanPhong;

    public QLNV() {
        dsGiangVien = new ArrayList<>();
        dsNghienCuuVien = new ArrayList<>();
        dsNhanVienVanPhong = new ArrayList<>();
    }

    public List<GiangVien> getDsGiangVien() {
        return dsGiangVien;
    }

    public void setDsGiangVien(List<GiangVien> dsGiangVien) {
        this.dsGiangVien = dsGiangVien;
    }

    public List<NghienCuuVien> getDsNghienCuuVien() {
        return dsNghienCuuVien;
    }

    public void setDsNghienCuuVien(List<NghienCuuVien> dsNghienCuuVien) {
        this.dsNghienCuuVien = dsNghienCuuVien;
    }

    public List<NhanVienVanPhong> getDsNhanVienVanPhong() {
        return dsNhanVienVanPhong;
    }

    public void setDsNhanVienVanPhong(List<NhanVienVanPhong> dsNhanVienVanPhong) {
        this.dsNhanVienVanPhong = dsNhanVienVanPhong;
    }

    public void nhap() {
        int n;
        String choose = null;
        System.out.print("Nhap so luong nhan vien: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("1. Giang vien.");
            System.out.println("2. Nghien cuu vien.");
            System.out.println("3. Nhan vien van phong.");
            while (true) {
                System.out.print("Nhap lua chon: ");
                choose = sc.nextLine();
                if (choose.equals("1") || choose.equals("2") || choose.equals("3")) {
                    break;
                }
            }
            switch (choose) {
            case "1":
                GiangVien giangVien = new GiangVien();
                System.out.println("----------------------------------------------------------------------------");
                giangVien.nhap();
                System.out.println("----------------------------------------------------------------------------");
                dsGiangVien.add(giangVien);
                break;
            case "2":
                NghienCuuVien nghienCuuVien = new NghienCuuVien();
                System.out.println("----------------------------------------------------------------------------");
                nghienCuuVien.nhap();
                System.out.println("----------------------------------------------------------------------------");
                dsNghienCuuVien.add(nghienCuuVien);
                break;
            case "3":
                NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong();
                System.out.println("----------------------------------------------------------------------------");
                nhanVienVanPhong.nhap();
                System.out.println("----------------------------------------------------------------------------");
                dsNhanVienVanPhong.add(nhanVienVanPhong);
                break;
            }
        }
    }

    public void xuat() {
        System.out.println(
                "--------------------------------nhan vien lao dong tien tien--------------------------------");
        System.out.println(
                "*******************************************GIANG VIEN******************************************************");
        System.out.format("%10s | %30s | %15s | %20s | %20s%n", "Ma GV", "Ten GV", "Ngay sinh", "So tiet trong nam",
                "So de tai huong dan");
        for (GiangVien giangVien : dsGiangVien) {
            if (giangVien.xetLaoDongTienTien()) {
                giangVien.xuat();
            }
        }
        System.out.println(
                "******************************************NGHIEN CUU VIEN**************************************************");
        System.out.format("%10s | %30s | %15s | %20s | %20s%n", "Ma NCV", "Ten NCV", "Ngay sinh", "So de tai",
                "So bai bao cao");
        for (NghienCuuVien nghienCuuVien : dsNghienCuuVien) {
            if (nghienCuuVien.xetLaoDongTienTien()) {
                nghienCuuVien.xuat();
            }
        }
        System.out.println(
                "****************************************NHAN VIEN VAN PHONG************************************************");
        System.out.format("%10s | %30s | %15s | %20s | %20s%n", "Ma NVVP", "Ten NVVP", "Ngay sinh", "So lop boi duong",
                "So gio LDCI");
        for (NhanVienVanPhong nhanVienVanPhong : dsNhanVienVanPhong) {
            if (nhanVienVanPhong.xetLaoDongTienTien()) {
                nhanVienVanPhong.xuat();
            }
        }
    }
}
