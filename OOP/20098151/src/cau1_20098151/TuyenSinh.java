package cau1_20098151;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh {
    static void showMenu() {
        System.out.println("1. Them n thi sinh");
        System.out.println("2. In thong tin thi sinh");
        System.out.println("3. Tim kiem theo sbd");
        System.out.println("0. Thoat");
    }

    static void tieuDe() {
        System.out.printf("%10s|%30s|%20s|%15s|%10s\n", "SBD", "Ten", "Dia chi", "Muc uu tien", "Khoi thi");
    }

    public static void main(String[] args) {
        ArrayList<ThiSinh> ds_ThiSinh = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            showMenu();
            while (true) {
                try {
                    System.out.print("Choose: ");
                    choose = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhap loi! Hay nhap lai!!! ");
                }
            }
            switch (choose) {
            case 1:
                int n;
                System.out.print("Nhap so luong thi sinh muon them: ");
                while (true) {
                    try {
                        n = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Nhap sai. Hay nhap lai (so luong > 0): ");
                    }
                }
                for (int i = 0; i < n; i++) {
                    ThiSinh thiSinh = new ThiSinh();
                    thiSinh.nhapThiSinh(sc);
                    ds_ThiSinh.add(thiSinh);
                }
                break;
            case 2:
                tieuDe();
                for (int i = 0; i < ds_ThiSinh.size(); i++) {
                    ds_ThiSinh.get(i).hienThiThiSinh();
                }
                break;
            case 3:
                int sbd;
                System.out.print("Nhap so bao danh can tim: ");
                sbd = Integer.parseInt(sc.nextLine());
                boolean check = false;
                for (int i = 0; i < ds_ThiSinh.size(); i++) {
                    if (sbd == ds_ThiSinh.get(i).getSbd()) {
                        tieuDe();
                        ds_ThiSinh.get(i).hienThiThiSinh();
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    System.out.println("Khong co thi sinh nao co ma la " + sbd);
                }
                break;
            case 0:
                choose = 0;
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Khong ton tai chuc nang tren. Hay chon lai.");
                break;
            }
        } while (choose != 0);
        sc.close();
    }
}
