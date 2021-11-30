public class GiangVien extends NhanVien {
    private int soTietTrongNam;
    private int soDeTaiHD;

    public GiangVien() {
    }

    public int getSoTietTrongNam() {
        return soTietTrongNam;
    }

    public void setSoTietTrongNam(int soTietTrongNam) {
        this.soTietTrongNam = soTietTrongNam;
    }

    public int getSoDeTaiHD() {
        return soDeTaiHD;
    }

    public void setSoDeTaiHD(int soDeTaiHD) {
        this.soDeTaiHD = soDeTaiHD;
    }

    public int nhapSoTietTrongNam() {
        System.out.print("Nhap so tiet trong nam: ");
        while (true) {
            try {
                int soTietTrongNam = Integer.parseInt(sc.nextLine());
                if (soTietTrongNam < 0) {
                    throw new NumberFormatException();
                }
                return soTietTrongNam;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so tiet trong nam: ");
            }
        }
    }

    public int nhapSoDeTaiHD() {
        System.out.print("Nhap so de tai huong dan: ");
        while (true) {
            try {
                int soDeTaiHD = Integer.parseInt(sc.nextLine());
                if (soDeTaiHD < 0) {
                    throw new NumberFormatException();
                }
                return soDeTaiHD;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so de tai huong dan: ");
            }
        }
    }

    @Override
    public void nhap() {
        super.nhap();
        setSoTietTrongNam(nhapSoTietTrongNam());
        setSoDeTaiHD(nhapSoDeTaiHD());
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.format("| %20d | %20d%n", soTietTrongNam, soDeTaiHD);
    }

    public boolean xetLaoDongTienTien() {
        if (soTietTrongNam >= 300 && soDeTaiHD >= 5) {
            return true;
        }
        return false;
    }
}
