public class Student extends Person{
    private String rollNo; //8 ki tu
    private double mark;
    private String email;

    public Student() {
        super();
    }

    public String getRollNo() {
        return this.rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.err.print("Nhap MSSV loi! Hay nhap lai: ");
            return false;
        }
    }

    public double getMark() {
        return this.mark;
    }

    public boolean setMark(double mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.err.print("Nhap diem loi!Hay nhap lai: ");
            return false;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") & !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.print("Nhap loi! Hay nhap lai: ");
            return false;
        }
    }
    public boolean checkScholarship(){
        if (this.mark >= 8){
            return true;
        }
        return false;
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.print("Nhap ma sinh vien: ");
        while (!setRollNo(sc.nextLine()));
        System.out.print("Nhap diem trung binh: ");
        while (true) {
            double inputMark = Double.parseDouble(sc.nextLine());
            boolean check = setMark(inputMark);
            if (check == true) {
                break;
            }
        }
        System.out.print("Nhap email: ");
        while (!setEmail(sc.nextLine()));
    }
    
    @Override
    public void showInfo(){
        System.out.println("MSSV: " + getRollNo());
        super.showInfo();
        System.out.println("Diem trung binh: " + getMark());
        System.out.println("Email: " + getEmail());
    }
}
