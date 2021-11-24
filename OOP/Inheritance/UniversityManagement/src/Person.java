import java.util.Scanner;

/**
 * Person class
 * 
 * @author MinhQuan
 */
public class Person {
    private String name;
    private String address;
    public static Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%30s | %20s | ", name, address);
    }
}