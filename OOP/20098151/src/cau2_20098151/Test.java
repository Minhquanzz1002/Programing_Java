package cau2_20098151;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static void tieuDe() {
        System.out.printf("%30s|%10s|%20s|%10s|%15s|%15s|%15s|%15s\n", "Ho ten", "Tuoi", "Que quan", "Ma GV",
                "Luong cung", "Luong thuong", "Tien phat", "Luong thuc linh");
    }

    public static void xoaCBGV(String id, ArrayList<CBGV> list_CanBo) {
        CBGV canBo = null;
        int size = list_CanBo.size();
        for (int i = 0; i < size; i++) {
            Nguoi nguoi = list_CanBo.get(i).getCanBo();
            if (nguoi.getMaGV().equals(id)) {
                canBo = list_CanBo.get(i);
                break;
            }
        }
        if (canBo != null) {
            list_CanBo.remove(canBo);
        } else {
            System.out.println("Khong co can bo nao co ma " + id + " de xoa");
        }
    }

    public static void main(String[] args) {
        ArrayList<CBGV> list_CanBo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap so luong can bo muon them: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            CBGV canBo = new CBGV();
            canBo.themCBGV(sc);
            list_CanBo.add(canBo);
        }
        tieuDe();
        for (int i = 0; i < n; i++) {
            list_CanBo.get(i).hienthiCBGV();
        }
        String id;
        System.out.print("Nhap id can bo can xoa: ");
        id = sc.nextLine();
        xoaCBGV(id, list_CanBo);
        System.out.println("Danh sach sau khi xoa");
        tieuDe();
        for (int i = 0; i < list_CanBo.size(); i++) {
            list_CanBo.get(i).hienthiCBGV();
        }
        sc.close();

    }
}
