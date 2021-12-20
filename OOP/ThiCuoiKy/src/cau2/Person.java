package cau2;

public class Person {
    private String name;
    private int year;
    protected String id;

    Person(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDetail() {
        return String.format("%30s|%10d|%10s", name, year, id);
    }
}
