public class ReferenceBook extends Book {
    private double tax; // thue

    public ReferenceBook() {
    }

    public ReferenceBook(int id, String receiptDate, double cost, int quantity, String publisher, double tax) {
        super(id, receiptDate, cost, quantity, publisher);
        this.tax = tax;
    }

    @Override
    public double calculateTotalCost() {
        return (quantity * cost) + tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%10d|%15s|%20.2f|%10d|%20s|%10.2f", id, convertDateToString(), cost, quantity, publisher, tax);
    }

}
