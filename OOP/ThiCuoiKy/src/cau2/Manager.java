package cau2;

public class Manager extends Employee {
    private Employee assistant; // tro ly

    Manager(Person person, int salary, Employee assistant) {
        super(person, salary);  // thong tin cua Manager
        this.assistant = assistant;
    }

    @Override
    public String getDetail() {
        return super.getDetail();
    }

    public Employee getAssistant() {
        return assistant;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
