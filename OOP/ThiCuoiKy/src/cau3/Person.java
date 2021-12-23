package cau3;

import java.util.Scanner;

public class Person {
    protected static Scanner sc = new Scanner(System.in);
    private String name;
    private String gender;

    Person() {
        super();
    }

    /**
     * Nhap du lieu cho "gioi tinh"
     * @return chuoi gioi tinh (nam/nu)
     */
    public String inputGender() {
        String gender;
        System.out.print("Nhap gioi tinh(nam/nu): ");
        while (true) {
            gender = sc.nextLine();
            if (gender.equalsIgnoreCase("nam")|| gender.equalsIgnoreCase("nu")) {
                return gender.trim();
            }
            System.out.print("Nhap loi! Hay nhap lai gioi tinh(nam/nu): ");
        }
    }

    /**
     * Nhap du lieu cho "ten"
     * @return chuoi ten
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
     * Nhap du lieu cho "nguoi"
     */
    public void inputPerson(){
        this.name = inputName();
        this.gender = inputGender();
    }

    // Getter && Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%-30s|%-10s", name, gender);
    }
}
