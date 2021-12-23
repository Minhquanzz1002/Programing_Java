package cau3;

import java.util.Scanner;

public class Person {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String gender;

    Person() {

    }

    // Input values
    public String inputGender() {
        String gender;
        System.out.print("Nhap gioi tinh: ");
        while (true) {
            try {
                gender = sc.nextLine();
                if (gender.equalsIgnoreCase("nam") == true|| gender.equalsIgnoreCase("nu") == true) {
                    return gender;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.print("Nhap loi! Hay nhap lai gioi tinh(nam/nu): ");
            }
        }
    }

    public String inputName() {
        String name;
        System.out.print("Nhap ten: ");
        while (true) {
            try {
                name = sc.nextLine();
                if (name.matches("^[a-zA-Z]+[a-zA-Z\\s]+$") && name.contains("  ") == false) {
                    return name;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.print("Nhap loi! Hay nhap lai ten: ");
            }
        }
    }

    public void nhap(){
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
