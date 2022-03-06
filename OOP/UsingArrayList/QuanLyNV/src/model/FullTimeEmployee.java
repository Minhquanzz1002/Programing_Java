package model;

public class FullTimeEmployee extends Employee{
    private double hardSalary; // luong cung
    private double fine;    // tien phat
    private double bonus;

    public FullTimeEmployee(double hardSalary, double fine, double bonus) {
        this.hardSalary = hardSalary;
        this.fine = fine;
        this.bonus = bonus;
    }

    public FullTimeEmployee(int id, String name, byte age, int phone, String mail, double hardSalary, double fine, double bonus) {
        super(id, name, age, phone, mail);
        this.hardSalary = hardSalary;
        this.fine = fine;
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return (hardSalary + fine) - bonus;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "hardSalary=" + hardSalary +
                ", fine=" + fine +
                ", bonus=" + bonus +
                '}';
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
