package cau1;

public class Cylinder extends Circle {
    private double height;

    Cylinder() {
        super();
        this.height = inputHeight();
    }

    protected double inputHeight() {
        double height;
        System.out.print("Nhap chieu cao(h > 0): ");
        while (true) {
            try {
                height = Double.parseDouble(sc.nextLine());
                if (height <= 0) {
                    throw new NumberFormatException();
                }
                return height;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Nhap lai chieu cao(h > 0): ");
            }
        }
    }

    public double tinhDienTichXungQuanh() {
        return 2 * Math.PI * radius * height;
    }

    public double tinhDienTichHaiDay() {
        return this.getArea() * 2;
    }

}
