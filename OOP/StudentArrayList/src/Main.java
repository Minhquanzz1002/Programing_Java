import java.util.Scanner;

public class Main {
    public static void showMenu(){
        System.out.println("--------------------------menu--------------------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. Exit.");
        System.out.println("--------------------------------------------------------");
        System.out.println("Please choose: ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
            showMenu();
            try{
                System.out.print("Choose: ");
                choose = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.err.println("Nhap loi! Tu dong thoat!");
                choose = 0;
            }
            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Exited");
                    break;
                default:

                    break;
            }
        }while(choose != 0);
        sc.close();
    }
}
