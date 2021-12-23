package cau1;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("------------------Hinh tron------------------");
        System.out.format("Chu vi hinh tron: %.2f%n", circle.getPerimeter());
        System.out.format("Dien tich hinh tron: %.2f%n%n", circle.getArea());
        
        Cylinder cylinder = new Cylinder();
        System.out.println("------------------Hinh tru-------------------");
        System.out.printf("Dien tich hai day: %.2f%n", cylinder.tinhDienTichHaiDay());
        System.out.printf("Dien tich xung quanh: %.2f%n", cylinder.tinhDienTichXungQuanh());
    }
}
