package cau2;

public class Manager extends Employee {
    private Employee assistant; // tro ly

    Manager(Person person, int salary, Employee assistant) {
        super(person, salary);  // thong tin cua Manager
        this.assistant = assistant; // thong tin tro ly
    }

    @Override
    public String getDetail() {
        return super.getDetail();
    }

    // Getter && Setter
    public Employee getAssistant() {
        return assistant;
    }

    public void setAssistant(Employee assistant) {
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
