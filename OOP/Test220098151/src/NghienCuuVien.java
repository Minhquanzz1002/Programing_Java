public class NghienCuuVien extends NhanVien {
    private int soDeTai;
    private int soBaiBaoCao;

    public NghienCuuVien() {
    }

    public int getSoDeTai() {
        return soDeTai;
    }

    public void setSoDeTai(int soDeTai) {
        this.soDeTai = soDeTai;
    }

    public int getSoBaiBaoCao() {
        return soBaiBaoCao;
    }

    public void setSoBaiBaoCao(int soBaiBaoCao) {
        this.soBaiBaoCao = soBaiBaoCao;
    }

    public int nhapSoDeTai() {
        System.out.print("Nhap so de tai: ");
        while (true) {
            try {
                int soDeTai = Integer.parseInt(sc.nextLine());
                if (soDeTai < 0) {
                    throw new NumberFormatException();
                }
                return soDeTai;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so de tai: ");
            }
        }
    }

    public int nhapSoBaiBaoCao() {
        System.out.print("Nhap so bai bao cao: ");
        while (true) {
            try {
                int soBaiBaoCao = Integer.parseInt(sc.nextLine());
                if (soBaiBaoCao < 0) {
                    throw new NumberFormatException();
                }
                return soBaiBaoCao;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so bai bao cao: ");
            }
        }
    }

    @Override
    public void nhap() {
        super.nhap();
        setSoDeTai(nhapSoDeTai());
        setSoBaiBaoCao(nhapSoBaiBaoCao());
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.format("| %20d | %20d%n", soDeTai, soBaiBaoCao);
    }

    public boolean xetLaoDongTienTien() {
        if (soDeTai >= 1 && soBaiBaoCao >= 2) {
            return true;
        }
        return false;
    }
}
