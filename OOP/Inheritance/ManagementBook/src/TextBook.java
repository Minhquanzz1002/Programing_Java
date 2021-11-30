public class TextBook extends Book {
    private String status;

    public TextBook() {
    }

    public TextBook(int id, String receiptDate, double cost, int quantity, String publisher, String status) {
        super(id, receiptDate, cost, quantity, publisher);
        this.status = status;
    }

    @Override
    public double calculateTotalCost() {
        if (status.equalsIgnoreCase("Moi")) {
            return quantity * cost;
        }
        return quantity * cost * 0.5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return String.format("%10d|%15s|%20.2f|%10d|%20s|%10s", id, convertDateToString(), cost, quantity, publisher, status);
    }
}
