package cau2;

public class Employee extends Person {
    private int salary;

    Employee(Person person, int salary) {
        super(person.getName(), person.getYear(), person.id);
        this.salary = salary;
    }

    public int inputSalary() {
        int salary = 0;
        System.out.print("Nhap luong: ");
        while (true) {
            try {
                salary = Integer.parseInt(sc.nextLine());
                if (salary < 0) {
                    throw new NumberFormatException();
                }
                return salary;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai luong nhan vien: ");
            }
        }
    }

    public void inputEmployee() {
        this.setName(this.inputName());
        this.setYear(this.inputYear());
        this.id = inputId();
        this.salary = inputSalary();
    }

    @Override
    public String getDetail() {
        return String.format("%30s|%10d|%10s|%10d", this.getName(), this.getYear(), id, salary);
    }

    /**
     * Kiem tra xem nhan vien da co trong cty chua
     * 
     * @param dsNV danh sach nhan vien trong cty
     * @return Dung/Sai
     */
    public boolean kiemTraTonTai(Employee[] dsNV) {
        for (int i = 0; i < dsNV.length; i++) {
            if (this.equals(dsNV[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            if (e.id.equals(this.id) == true && e.salary == this.salary && e.getName().equals(this.getName()) == true
                    && e.getYear() == this.getYear()) {
                return true;
            }
            return false;
        }
        return false;
    }

    // Getter && Setter
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
