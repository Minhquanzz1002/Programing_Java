package cau2;

import java.util.Scanner;

public class Product {
    public static Scanner sc = new Scanner(System.in);
    private String Id;
    private String Name;
    private int Quantity;
    private double UnitPrice;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Product(String id, String name, int quantity, double unitPrice) {
        super();
        Id = id;
        Name = name;
        Quantity = quantity;
        UnitPrice = unitPrice;
    }
    
    public Product() {
    }

    @Override
    public String toString() {
        return String.format("%10s|%20s|%10d|%10.2f%n", Id, Name, Quantity, UnitPrice);
    }


    public int inputQuantity() {
        int quantity;
        System.out.print("Nhap so luong: ");
        while (true) {
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                return quantity;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so luong: ");
            }
        }
    }

    public double inputUnitPrice() {
        double unitPrice;
        System.out.print("Nhap don gia: ");
        while (true) {
            try {
                unitPrice = Double.parseDouble(sc.nextLine());
                if (unitPrice < 0) {
                    throw new NumberFormatException();
                }
                return unitPrice;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai so luong (don gia > 0): ");
            }
        }
    }

    // public String inputString(){
    //     String a = null;
        
    // }
    public void nhapSanPham(){
        System.out.println("----------------------------------------------------------");
        System.out.print("Nhap ID san pham: ");
        this.Id = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        this.Name = sc.nextLine();
        this.Quantity = inputQuantity();
        this.UnitPrice = inputUnitPrice();
    }
}
