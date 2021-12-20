package cau2;

public class Employee extends Person{
    private int salary;

    
    @Override
    public String getDetail(){
        return String.format("%30s|%10d|%10s|%10d", this.getName(), this.getYear(), id, salary);
    }
}
