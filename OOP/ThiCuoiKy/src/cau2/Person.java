package cau2;

import java.util.Calendar;
import java.util.Scanner;

public class Person {
    protected static Scanner sc = new Scanner(System.in);
    private String name;
    private int year;       // nam sinh
    protected String id;

    Person(String name, int year, String id) {
        this.name = name;
        this.year = year;
        this.id = id;
    }

    /**
     * Nhap du lieu cho "ten"
     * @return ten
     */
    public String inputName() {
        String name;
        System.out.print("Nhap ten: ");
        while (true) {
            name = sc.nextLine();
            if (name.matches("^[a-zA-Z]+[a-zA-Z\\s]+$") && name.contains("  ") == false) {
                return name.trim();
            }
            System.out.print("Nhap loi! Hay nhap lai ten: ");
        }
    }

    /**
     * Nhap du lieu cho "nam sinh"
     * @return nam sinh
     */
    public int inputYear() {
        int year = 0;
        Calendar cal = Calendar.getInstance();
        System.out.print("Nhap nam: ");
        while (true) {
            try {
                year = Integer.parseInt(sc.nextLine());
                if (cal.get(Calendar.YEAR) - year < 18 || cal.get(Calendar.YEAR) - year > 60) { // tuoi [18,60]
                    throw new NumberFormatException();
                }
                return year;
            } catch (NumberFormatException e) {
                System.err.print("Nhap loi! Hay nhap lai nam sinh: ");
            }
        }
    }

    /**
     * Nhap du lieu cho ID
     * @return ID
     */
    public String inputId() {
        String id;
        System.out.print("Nhap ID: ");
        while (true) { 
            id = sc.nextLine();
            if (id.matches("[a-zA-Z0-9]+")) { // ID chi chua chu hoac so
                return id.trim();
            }
            System.err.print("Nhap loi! Hay nhap lai ID: ");
        }
    }

    /**
     * Nhap du lieu cho cac du lieu trong class
     */
    public void inputPerson() {
        this.name = inputName();
        this.year = inputYear();
        this.id = inputId();
    }

    // Getter && Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDetail() {
        return String.format("%30s|%10d|%10s", name, year, id);
    }
    
}
