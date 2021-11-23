import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String dob;
    private String address;
    public static Scanner sc = new Scanner(System.in);
    public Person() {
    }

    public Person(String name, String gender, String dob, String address) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public boolean setName(String name) {
        if (name != null) {
            this.name = name;
            return true;
        } else {
            System.err.print("Nhap ten sai! Hay nhap lai: ");
            return false;
        }
    }

    public String getGender() {
        return this.gender;
    }

    public boolean setGender(String gender) {
        if (gender != null){
            this.gender = gender;
            return true;
        }else{
            System.err.print("Nhap sai! Hay nhap lai: ");
            return false;
        }
    }

    public String getDob() {
        return this.dob;
    }

    public boolean setDob(String dob) {
        if (dob != null){
            this.dob = dob;
            return true;
        }else{
            System.err.print("Nhap sai! Hay nhap lai: ");
            return false;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public boolean setAddress(String address) {
        if (address != null){
            this.address = address;
            return true;
        }else{
            System.err.print("Nhap sai! Hay nhap lai: ");
            return false;
        }
    }

    public void inputInfo() {
        System.out.print("Nhap ten: ");
        while(!setName(sc.nextLine()));
        System.out.print("Nhap gioi tinh: ");
        while(!setGender(sc.nextLine()));
        System.out.print("Nhap ngay sinh: ");
        while(!setGender(sc.nextLine()));
        System.out.print("Nhap dia chi: ");
        while(!setAddress(sc.nextLine()));
    }

    public void showInfo() {
        System.out.println("Ten: " + getName());
        System.out.println("Gioi tinh: " + getGender());
        System.out.println("Ngay sinh: " + getAddress());
        System.out.println("Dia chi: " + getAddress());
    }
}
