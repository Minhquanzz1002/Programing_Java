public class NhanVienVanPhong extends NhanVien {
    private int soLopBoiDuong;
    private int soGioCongIch;

    public NhanVienVanPhong() {
    }

    public int getSoLopBoiDuong() {
        return soLopBoiDuong;
    }

    public void setSoLopBoiDuong(int soLopBoiDuong) {
        this.soLopBoiDuong = soLopBoiDuong;
    }

    public int getSoGioCongIch() {
        return soGioCongIch;
    }

    public void setSoGioCongIch(int soGioCongIch) {
        this.soGioCongIch = soGioCongIch;
    }

    public int nhapSoLopBoiDuong() {
        System.out.print("Nhap so lop boi duong: ");
        while (true) {
            try {
                int soLopBoiDuong = Integer.parseInt(sc.nextLine());
                if (soLopBoiDuong < 0) {
                    throw new NumberFormatException();
                }
                return soLopBoiDuong;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so lop boi duong: ");
            }
        }
    }

    public int nhapSoGioCongIch() {
        System.out.print("Nhap so gio cong ich: ");
        while (true) {
            try {
                int soGioCongIch = Integer.parseInt(sc.nextLine());
                if (soGioCongIch < 0) {
                    throw new NumberFormatException();
                }
                return soGioCongIch;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so gio cong ich: ");
            }
        }
    }

    @Override
    public void nhap() {
        super.nhap();
        setSoLopBoiDuong(nhapSoLopBoiDuong());
        setSoGioCongIch(nhapSoGioCongIch());
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.format("| %20d | %20d%n", soLopBoiDuong, soGioCongIch);
    }


    public boolean xetLaoDongTienTien() {
        if (soLopBoiDuong >= 1 && soGioCongIch >= 20) {
            return true;
        }
        return false;
    }
}
