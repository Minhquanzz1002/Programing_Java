package cau1;

public class Cylinder extends Circle {
    private double height;  // chieu cao

    Cylinder() {
        super();
        this.height = inputHeight();
    }

    /**
     * Nhap du lieu cho chieu cao
     * @return chieu cao
     */
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

    // Getter && Setter
    public double tinhDienTichXungQuanh() {
        return this.getPerimeter() * height;
    }

    public double tinhDienTichHaiDay() {
        return this.getArea() * 2;
    }
}
