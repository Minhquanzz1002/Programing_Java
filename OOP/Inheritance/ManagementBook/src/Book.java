import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Book {
    public static Scanner sc = new Scanner(System.in);
    protected int id;
    protected Date receiptDate; // ngay nhap
    protected double cost; // don gia
    protected int quantity; // so luong
    protected String publisher; // nha xuat ban

    public abstract double calculateTotalCost();

    protected Book() {
    }

    protected Book(int id, String receiptDate, double cost, int quantity, String publisher) {
        this.id = id;
        this.receiptDate = convertStringToDate(receiptDate);
        this.cost = cost;
        this.quantity = quantity;
        this.publisher = publisher;
    }

    /**
     * Chuyen tu kieu String sang Date
     * 
     * @param receiptDate ngay nhap kieu String
     * @return ngay nhap kieu Date
     */
    protected Date convertStringToDate(String receiptDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(receiptDate);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Chuyen tu kieu Date sang String
     * 
     * @return chuoi ngay nhap
     */
    protected String convertDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(receiptDate);
    }

    // Getter && Setter
    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected Date getReceiptDate() {
        return receiptDate;
    }

    protected void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    protected void setReceiptDate(String receiptDate) {
        this.receiptDate = convertStringToDate(receiptDate);
    }

    protected double getCost() {
        return cost;
    }

    protected void setCost(double cost) {
        this.cost = cost;
    }

    protected int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected String getPublisher() {
        return publisher;
    }

    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String showInfo(){
        return String.format("%10d|%15s|%20.2f|%10d|%20s", id, convertDateToString(), cost, quantity, publisher);
    }

    @Override
    public String toString() {
        return String.format("%10d|%15s|%20.2f|%10d|%20s", id, convertDateToString(), cost, quantity, publisher);
    }

}
