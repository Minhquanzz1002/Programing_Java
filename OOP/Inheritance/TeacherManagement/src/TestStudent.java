
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestStudent {
    public static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("1. Nhap N sinh vien.");
        System.out.println("2. Hien thi thong tin sinh vien.");
        System.out.println("3. Hien thi max min theo diem trung binh. ");
        System.out.println("4. Tim kiem theo MSSV.");
        System.out.println("5. Sort theo A-Z.");
        System.out.println("6. Hien thi sinh vien duoc hoc bong & sap xep tu cao den thap");
        System.out.println("0. Thoat.");
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        String choose = null;
        int n;
        int minIndex = 0, maxIndex = 0;
        double minMark, maxMark;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                System.out.print("Nhap so sinh vien can them: ");
                while(true){
                    try {
                        n = Integer.parseInt(sc.nextLine());
                        if (n <= 0){
                            throw new NumberFormatException();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Nhap loi hay nhap lai: ");
                    }
                }
                for (int i = 0; i < n; i++) {
                    Student std = new Student();
                    std.inputInfo();
                    students.add(std);
                }
                break;
            case "2":
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).showInfo();
                }
                break;
            case "3":
                minMark = students.get(0).getMark();
                maxMark = students.get(0).getMark();
                for (int i = 1; i < students.size(); i++) {
                    if (students.get(i).getMark() < minMark) {
                        minIndex = i;
                        minMark = students.get(i).getMark();
                    }
                    if (students.get(i).getMark() > maxMark) {
                        maxIndex = i;
                        maxMark = students.get(i).getMark();
                    }

                }
                System.out.println("Sinh vien co diem trung binh cao nhat");
                students.get(maxIndex).showInfo();
                System.out.println("Sinh vien co diem trung binh thap nhat");
                students.get(minIndex).showInfo();
                break;
            case "4":
                String rollNoSearch;
                int count = 0;
                try {
                    System.out.println("Nhap MSSV can tim: ");
                    rollNoSearch = sc.nextLine();
                } catch (Exception e) {
                    System.err.println("Nhap loi! Tu thoat tim kiem.");
                    break;
                }
                for (Student student : students) {
                    if (student.getRollNo().equals(rollNoSearch)) {
                        student.showInfo();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Khong tim thay");
                }
                break;
            case "5":
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int cmp = o1.getName().compareTo(o2.getName());
                        if (cmp >= 0) {
                            return 1;
                        }
                        return -1;
                    }
                });
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).showInfo();
                }
                break;
            case "6":
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getMark() >= o2.getMark() ? -1 : 1;
                    }
                });
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).checkScholarship()) {
                        students.get(i).showInfo();
                    }
                }
                break;
            case "0":
                System.out.println("Thoat");
                break;
            }
        } while (!choose.equals("0"));
    }
}
