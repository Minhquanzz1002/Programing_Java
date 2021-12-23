package cau3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<CapKhieuVu> dsKhieuVu = new LinkedList<>();
        CapKhieuVu[] cap = new CapKhieuVu[3];
        cap[0] = new CapKhieuVu();
        cap[1] = new CapKhieuVu();
        cap[2] = new CapKhieuVu();

        cap[0].themDoi(dsKhieuVu.size());
        dsKhieuVu.offer(cap[0]);
        cap[1].themDon(dsKhieuVu.size());
        dsKhieuVu.offer(cap[1]);
        // cap[2].themDoi(dsKhieuVu.size());
        // dsKhieuVu.offer(cap[2]);

        System.out.format("%n%10s|%-30s|%-10s%n", "Thu tu cap", "Ten", "Gioi tinh");

        Iterator<CapKhieuVu> itor = dsKhieuVu.iterator();
        while (itor.hasNext()) {
            CapKhieuVu x = itor.next();
            System.out.print(x);
        }
    }
}
