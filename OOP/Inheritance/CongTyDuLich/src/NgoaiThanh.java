public class NgoaiThanh extends ChuyenXe {
    private String noiDen;
    private int soNgay;

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public NgoaiThanh() {
        super();
        this.soNgay = 0;
        this.noiDen = "";
    }

    public NgoaiThanh(String maCX, String tenTX, String soXe, double doanhThu, String noiDen, int soNgay) {
        super(maCX, tenTX, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Noi Den: ");
        this.noiDen = sc.nextLine();
        System.out.print("So Ngay: ");
        this.soNgay = Integer.parseInt(sc.nextLine());
    }

    public String toString() {
        return "Chuyen Xe Ngoai Thanh" + super.toString()
                + "\nNoi Den: " + this.noiDen + "\nSo Ngay: " + this.soNgay
                + "\nDoanh Thu: " + this.doanhThu;
    }
}
