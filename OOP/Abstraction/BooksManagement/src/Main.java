import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("1. Insert new book.");
        System.out.println("2. View list of books.");
        System.out.println("3. Average Price.");
        System.out.println("4. Exit.");
    }
    public static void main(String[] args) {
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                System.out.println("Exited");
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
        } while (!choose.equals("4"));
    }
}
