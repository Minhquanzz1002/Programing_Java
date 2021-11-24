import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Management class
 * 
 * @author MinhQuan
 */
public class Management {
    public static Scanner sc = new Scanner(System.in);
    private List<Student> studentList;
    private List<Employee> employeeList;
    private List<Customer> customerList;

    /**
     * init studentList, customerList and employeeList
     */
    public Management() {
        studentList = new ArrayList<>();
        customerList = new ArrayList<>();
        employeeList = new ArrayList<>();
    }

    /**
     * add student to studentList
     */
    public void addStudent() {
        Student student = new Student();
        student.setName(inputName());
        student.setAddress(inputAddress());
        student.setMark1(student.inputMark());
        student.setMark2(student.inputMark());
        studentList.add(student);
    }

    /**
     * add employee to employeeList
     */
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setName(inputName());
        employee.setAddress(inputAddress());
        employee.setSalaryCoefficient(employee.inputSalaryCoefficient());
        employeeList.add(employee);
    }

    /**
     * add customer to customerList
     */
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName(inputName());
        customer.setAddress(inputAddress());
        customer.setEvaluate(customer.inputEvaluate());
        customer.setInvoiceValue(customer.inputInvoiceValue());
        customer.setCompanyName(customer.inputCompanyName());
        customerList.add(customer);
    }

    /**
     * show list student to screen
     */
    public void showStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    /**
     * show list customer to screen
     */
    public void showCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    /**
     * show list employee to screen
     */
    public void showEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    /**
     * input person name
     * 
     * @return person name
     */
    public String inputName() {
        System.out.print("Input name: ");
        return sc.nextLine();
    }

    /**
     * input person address
     * 
     * @return person address
     */
    public String inputAddress() {
        System.out.print("Input address: ");
        return sc.nextLine();
    }

    // getter && setter
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
