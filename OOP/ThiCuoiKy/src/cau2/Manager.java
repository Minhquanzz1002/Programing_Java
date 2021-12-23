package cau2;

public class Manager extends Employee {
    private Employee assistant;

    public Manager(Person person, int salary, Employee assistant) {
        super(person, salary);
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
