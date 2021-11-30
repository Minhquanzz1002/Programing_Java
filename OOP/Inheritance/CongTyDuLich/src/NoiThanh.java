public class NoiThanh extends ChuyenXe {
    private double soKm;
    private String soTuyen;

    
    public double getSoKm() {
        return soKm;
    }

    public void setSoKm(double soKm) {
        this.soKm = soKm;
    }

    public String getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(String soTuyen) {
        this.soTuyen = soTuyen;
    }

    public NoiThanh() {
        super();
        this.soTuyen = "";
        this.soKm = 0;
    }

    public NoiThanh(String maCX, String tenTX, String soXe, double doanhThu, double soKm, String soTuyen) {
        super(maCX, tenTX, soXe, doanhThu);
        this.soKm = soKm;
        this.soTuyen = soTuyen;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap So Tuyen: ");
        this.soTuyen = sc.nextLine();
        System.out.print("So Km: ");
        this.soKm = Double.parseDouble(sc.nextLine());
    }

    public String toString() {
        return "Chuyen Xe Noi Thanh " + super.toString()
                + "\n So Tuyen: " + this.soTuyen + "\nSo Km: " + this.soKm
                + "\nDoanh Thu: " + this.doanhThu;
    }
}
