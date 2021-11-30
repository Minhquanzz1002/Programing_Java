import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("1. Insert News.");
        System.out.println("2. View list News.");
        System.out.println("3. Average rate.");
        System.out.println("4. Exit.");
        System.out.print("Option: ");
    }
    public static void main(String[] args) {
        ArrayList<News> newsList = new ArrayList<>();
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                newsList.add(new News(newsList.size() + 1));
                break;
            case "2":
                if (newsList.isEmpty()) {
                    System.out.println("Danh sach rong!");
                    break;
                }
                for (News news : newsList) {
                    news.display();
                    System.out.println("");
                }
                break;
            case "3":
                if (newsList.isEmpty()) {
                    System.out.println("Danh sach rong!");
                    break;
                }
                for (News news : newsList) {
                    news.display();
                    news.calculate();
                    System.out.format("|%10s%n", news.getAverageRate());
                }
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
