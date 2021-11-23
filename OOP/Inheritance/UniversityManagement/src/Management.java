import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    public static Scanner sc = new Scanner(System.in);
    private List<Student> studentList;
    private List<Employee> employeeList;
    private List<Customer> customerList;

    public Management() {
        studentList = new ArrayList<>();
        customerList = new ArrayList<>();
        employeeList = new ArrayList<>();
    }

    public void addStudent() {
        Student student = new Student();
        student.setName(inputName());
        student.setAddress(inputAddress());
        student.setMark1(student.inputMark());
        student.setMark2(student.inputMark());
        studentList.add(student);
    }

    public void addEmployee() {
        Employee employee = new Employee();
        String name = inputName();
        String address = inputAddress();
        int salaryCoefficient = employee.inputSalaryCoefficient();
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalaryCoefficient(salaryCoefficient);
        employeeList.add(employee);
    }

    public void addCustomer() {
        Customer customer = new Customer();
        String name = inputName();
        String address = inputAddress();
        String companyName = customer.inputCompanyName();
        int invoiceValue = customer.inputInvoiceValue();
        String evaluate = customer.inputEvaluate();
        customer.setName(name);
        customer.setAddress(address);
        customer.setEvaluate(evaluate);
        customer.setInvoiceValue(invoiceValue);
        customer.setCompanyName(companyName);
        customerList.add(customer);
    }

    public void showStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public void showCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    public void showEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public void edit() {

    }

    public void delete() {

    }

    public String inputName() {
        System.out.print("Input name: ");
        return sc.nextLine();
    }

    public String inputAddress() {
        System.out.print("Input address: ");
        return sc.nextLine();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

}
