import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("1. Insert book.");
        System.out.println("2. Update book.");
        System.out.println("3. Remove book.");
        System.out.println("4. Sort ascending book by cost.");
        System.out.println("5. Sort descending book by cost.");
        System.out.println("6. View list of books.");
        System.out.println("7. View list of textbooks.");
        System.out.println("8. View list of reference books.");
        System.out.println("0. Exit.");
        System.out.print("Please choose: ");
    }
    public static void main(String[] args) {
        ManageBook manageBook = new ManageBook();
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    manageBook.insertBook();
                    break;
                case "2":
                    manageBook.update(manageBook.inputId());
                    manageBook.showBook();
                case "3":
                    manageBook.removeBook(manageBook.inputId());
                    break;
                case "4":
                    manageBook.sortAscendingByCost();
                    manageBook.showBook();
                    break;
                case "5":
                    manageBook.sortDescendingByCost();
                    manageBook.showBook();
                    break;
                case "6":
                    manageBook.showBook();
                    break;
                case "7":
                    manageBook.showTextBook();
                    break;
                case "8":
                    manageBook.showReferenceBook();
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
