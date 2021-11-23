import java.util.Scanner;

public class Customer extends Person {
    private String companyName;
    private int invoiceValue; // Gia tri don hang
    private String evaluate; // Danh gia
    public static Scanner sc = new Scanner(System.in);

    public Customer() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(int invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String inputCompanyName() {
        System.out.print("Input company name: ");
        return sc.nextLine();
    }

    public int inputInvoiceValue() {
        System.out.print("Input invoice value: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String inputEvaluate() {
        System.out.print("Input evaluate: ");
        return sc.nextLine();
    }

    public String toString(){
        return super.toString() + String.format("%20s | %10d | %20s", companyName, invoiceValue, evaluate);
    }
}
