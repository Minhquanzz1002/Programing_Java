package model;

public abstract class Employee {
    protected int id;
    protected String name;
    protected byte age;
    protected int phone;
    protected String mail;

    public Employee() {
    }

    public Employee(int id, String name, byte age, int phone, String mail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                '}';
    }

    public abstract double getSalary();
}
