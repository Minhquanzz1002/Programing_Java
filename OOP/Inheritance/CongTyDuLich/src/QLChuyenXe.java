import java.util.Scanner;

public class QLChuyenXe {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x;
        ListChuyenXe dscx = new ListChuyenXe();
        do {
            System.out.println("\n-----------------------------------");
            System.out.println("0. Exit");
            System.out.println("1. Them Chuyen Xe Noi Thanh");
            System.out.println("2. Them Chuyen Xe Ngoai Thanh");
            System.out.println("3. Hien thi danh muc Chuyen Xe");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("------>>");
            x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 1:
                    dscx.listcx(1);
                    break;
                case 2:
                    dscx.listcx(2);
                    break;
                case 3:
                    dscx.xuatTT();
                    break;
            }
        } while (x != 0);
    }
}
