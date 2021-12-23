package cau3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    /**
     * in danh sach khieu vu
     * @param dsKhieuVu danh sach nguoi den vu truong
     * @param n kieu di don/di theo cap (truyen 1/2)
     */
    public static void inDanhSachKhieuVu(Queue<CapKhieuVu> dsKhieuVu, int n){
        System.out.format("%-10s|%-30s|%-10s%n", "Thu tu", "Ten nguoi tham du", "Gioi tinh");
        Iterator<CapKhieuVu> itor = dsKhieuVu.iterator();
        while (itor.hasNext()) {
            CapKhieuVu x = itor.next();
            if (x.getCap().size() == n){
                System.out.print(x);
            }
        }
    }
    public static void main(String[] args) {
        Queue<CapKhieuVu> dsKhieuVu = new LinkedList<>();
        CapKhieuVu[] cap = new CapKhieuVu[3];
        cap[0] = new CapKhieuVu();
        cap[1] = new CapKhieuVu();
        cap[2] = new CapKhieuVu();

        cap[0].nhapDoi(dsKhieuVu.size());
        dsKhieuVu.offer(cap[0]);
        cap[1].nhapDon(dsKhieuVu.size());
        dsKhieuVu.offer(cap[1]);
        cap[2].nhapDoi(dsKhieuVu.size());
        dsKhieuVu.offer(cap[2]);

        System.out.println("\nDanh sach cap khieu vu");
        inDanhSachKhieuVu(dsKhieuVu, 2);
        System.out.println("\nDanh sach cac nguoi di don.");
        inDanhSachKhieuVu(dsKhieuVu, 1);
    }
}
