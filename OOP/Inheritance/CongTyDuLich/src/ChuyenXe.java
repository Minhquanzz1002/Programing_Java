import java.util.Scanner;

public class ChuyenXe {

    protected String maCX, tenTX, soXe;
    protected double doanhThu;
    public static Scanner sc = new Scanner(System.in);

    public String getMaCX() {
        return maCX;
    }

    public void setMaCX(String maCX) {
        this.maCX = maCX;
    }

    public String getTenTX() {
        return tenTX;
    }

    public void setTenTX(String tenTX) {
        this.tenTX = tenTX;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    protected ChuyenXe() {
        this.maCX = "";
        this.tenTX = "";
        this.soXe = "";
        this.doanhThu = 0;
    }

    

    protected ChuyenXe(String maCX, String tenTX, String soXe, double doanhThu) {
        this.maCX = maCX;
        this.tenTX = tenTX;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }

    protected void nhap() {
        System.out.print("Nhap Ma So Chuyen: ");
        this.maCX = sc.nextLine();
        System.out.print("Ho Ten Tai Xe: ");
        this.tenTX = sc.nextLine();
        System.out.print("So Xe: ");
        this.soXe = sc.nextLine();
        System.out.print("Doanh Thu: ");
        this.doanhThu = Double.parseDouble(sc.nextLine());
    }

    public String toString() {
        return "\nMS chuyen: " + this.maCX + "\nName Tai Xe: " + this.tenTX + "\nSo Xe: " + this.soXe;
    }

}
