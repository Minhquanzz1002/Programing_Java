import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("-------------------------------menu---------------------------------");
        System.out.println("1. Add student");
        System.out.println("2. Add employee");
        System.out.println("3. Add customer");
        System.out.println("4. Show student.");
        System.out.println("5. Show employee.");
        System.out.println("6. Show customer.");
        System.out.println(". Delete");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Please choose: ");
    }
    public static void main(String[] args) {
        Management management = new Management();
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                management.addStudent();
                break;
            case "2":
                management.addEmployee();
                break;
            case "3":
                management.addCustomer();
                break;
            case "4":
                management.showStudent();
            case "5":
                management.showEmployee();
                break;
            case "6":
                management.showCustomer();
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
