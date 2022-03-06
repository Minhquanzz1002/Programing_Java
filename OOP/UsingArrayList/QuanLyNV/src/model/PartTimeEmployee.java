package model;

public class PartTimeEmployee extends Employee{
    private int hoursWork;

    public PartTimeEmployee(int hoursWork) {
        this.hoursWork = hoursWork;
    }

    public PartTimeEmployee(int id, String name, byte age, int phone, String mail, int hoursWork) {
        super(id, name, age, phone, mail);
        this.hoursWork = hoursWork;
    }

    @Override
    public double getSalary() {
        return hoursWork * 100000;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hoursWork=" + hoursWork +
                '}';
    }

    public int getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(int hoursWork) {
        this.hoursWork = hoursWork;
    }
}
