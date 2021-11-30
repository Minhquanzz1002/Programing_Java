import java.util.Scanner;

public class ManagePhoneBook {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("1. Insert Phone.");
        System.out.println("2. Remove Phone.");
        System.out.println("3. Update Phone.");
        System.out.println("4. Search Phone.");
        System.out.println("5. Sort.");
        System.out.println("6. Show phone list");
        System.out.println("0. Exit.");
    }
    public static String inputName(){
        System.out.print("Nhap ten: ");
        return sc.nextLine();
    }
    public static String inputPhone(){
        System.out.print("Nhap SDT: ");
        return sc.nextLine();
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("Minh Quan", "0982527982");
        phoneBook.insertPhone("Manh Ha", "0973776072");
        phoneBook.insertPhone("Tien Lap", "0917749254");
        phoneBook.insertPhone("Dang Hoang", "0904770053");
        phoneBook.insertPhone("Trung Kien", "0974880788");
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                phoneBook.insertPhone(inputName(), inputPhone());
                break;
            case "2":
                phoneBook.removePhone(inputName());
                break;
            case "3":
                phoneBook.updatePhone(inputName(), inputPhone());
                break;
            case "4":
                phoneBook.searchPhone(inputName());
                break;
            case "5":
                phoneBook.sort();
                break;
            case "6":
                phoneBook.showList();
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
