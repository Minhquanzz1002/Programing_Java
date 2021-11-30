import java.util.Scanner;

public class NhanVien {
    private int maNV;
    private String ten;
    private String ngaySinh;
    public static Scanner sc = new Scanner(System.in);

    public NhanVien() {
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String nhapTen() {
        System.out.print("Nhap ten nhan vien: ");
        return sc.nextLine();
    }

    public String nhapNgaySinh() {
        System.out.print("Nhap ngay sinh(dd-MM-yyyy): ");
        while(true){
            String ngaySinh = sc.nextLine();
            if (ngaySinh.matches("\\d{1,2}-\\d{1,2}-\\d{4}")){
                return ngaySinh;
            }
            System.out.print("Nhap sai dinh dang! Nhap lai ngay sinh(dd-MM-yyyy): ");
        }
    }

    public int nhapMaNV() {
        System.out.print("Nhap ma NV: ");
        while (true) {
            try {
                int maNV = Integer.parseInt(sc.nextLine());
                return maNV;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai ma nv: ");
            }
        }
    }

    public void nhap() {
        setMaNV(nhapMaNV());
        setTen(nhapTen());
        setNgaySinh(nhapNgaySinh());
    }

    public void xuat() {
        System.out.format("%10d | %30s | %15s ", maNV, ten, ngaySinh);
    }
}
