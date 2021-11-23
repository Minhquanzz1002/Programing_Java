import java.util.Scanner;

public class Employee extends Person {
    private int salaryCoefficient;  // He so luong
    public static Scanner sc = new Scanner(System.in);
    public Employee() {
    }

    public int getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(int salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public int inputSalaryCoefficient(){
        System.out.print("Input salary coefficient: ");
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%10d", salaryCoefficient);
    }
}
