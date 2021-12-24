package cau1;

import java.util.Scanner;

public class Circle {
    protected static Scanner sc = new Scanner(System.in);
    private double radius;    // ban kinh

    Circle() {
        this.radius = inputRadius();
    }

    /**
     * Nhap du lieu cho ban kinh
     * @return ban kinh
     */
    public double inputRadius() {
        double radius;
        System.out.print("Nhap ban kinh(r > 0): ");
        while (true) {
            try {
                radius = Double.parseDouble(sc.nextLine());
                if (radius <= 0) {
                    throw new NumberFormatException();
                }
                return radius;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Nhap lai ban kinh(r > 0): ");
            }
        }
    }

    /**
     * Tinh dien tich hinh tron
     * @return S
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Tinh chu vi hinh tron
     * @return chu vi
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
