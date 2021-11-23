import java.util.Scanner;

public class TeacherTest {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("-----------------------menu--------------------------");
        System.out.println("1. Nhap N giang vien.");
        System.out.println("2. Hien thi thong tin tat ca giang vien.");
        System.out.println("3. Hien thi giang vien co luong cao nhat.");
        System.out.println("0. Exit.");
        System.out.println("-----------------------------------------------------");
        System.out.print("Lua chon cua ban: ");
    }
    public static void main(String[] args) {
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                break;
            case "0":
                System.out.println("Exited");
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
        } while (!choose.equals("0"));
    }
}
