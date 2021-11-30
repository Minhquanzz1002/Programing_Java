import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManageBook {
    public static Scanner sc = new Scanner(System.in);
    public static TextBook textBook;
    public static ReferenceBook referenceBook;
    private ArrayList<Book> bookList;
    
    public ManageBook() {
        bookList = new ArrayList<>();
    }

    /**
     * Chen 1 phan tu vao list
     */
    public void insertBook() {
        String choose = null;
        System.out.print("Insert for Textbook(0)/Reference Book(1): ");
        choose = sc.nextLine();
        int id = (bookList.size() > 0) ? (bookList.size() + 1) : 1;
        if (choose.equals("1")) {
            referenceBook = new ReferenceBook(id, inputReceiptDate(), inputCost(), inputQuantity(), inputPublisher(), inputTax());
            bookList.add(referenceBook);
        } else {
            textBook = new TextBook(id, inputReceiptDate(), inputCost(), inputQuantity(), inputPublisher(), inputStatus());
            bookList.add(textBook);
        }
    }

    /**
     * Sap xep tang theo cost
     */
    public void sortAscendingByCost() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getCost() > o2.getCost()) {
                    return 1;
                } else if (o1.getCost() == o2.getCost()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    /**
     * Sap xep giam theo cost
     */
    public void sortDescendingByCost() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o2.getCost() > o1.getCost()) {
                    return 1;
                } else if (o2.getCost() == o1.getCost()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    /**
     * update toan bo du lieu theo ID
     * @param id ID nhap tu ban phim
     */
    public void update(int id) {
        int size = bookList.size();
        for (int i = 0; i < size; i++) {
            if (bookList.get(i).getId() == id) {
                if (bookList.get(i) instanceof TextBook) {
                    textBook = new TextBook(id, inputReceiptDate(), inputCost(), inputQuantity(), inputPublisher(), inputStatus());
                    bookList.set(i, textBook);
                } else {
                    referenceBook = new ReferenceBook(id, inputReceiptDate(), inputCost(), inputQuantity(), inputPublisher(), inputTax());
                    bookList.set(i, referenceBook);
                }
                return;
            }
        }
        System.out.format("%d khong ton tai%n", id);
    }
    
    /**
     * Xoa danh sach theo ID
     * @param id ID cua book
     */
    public void removeBook(int id) {
        textBook = null;
        referenceBook = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                if (book instanceof TextBook) {
                    textBook = (TextBook) book;
                } else {
                    referenceBook = (ReferenceBook) book;
                }
                break;
            }
        }
        if (textBook != null) {
            bookList.remove(textBook);
        } else if (referenceBook != null) {
            bookList.remove(referenceBook);
        } else {
            System.out.format("id = %d not existed%n", id);
        }
    }

    /**
     * Hien thi toan bo danh sach book
     */
    public void showBook() {
        System.out.format("%10s|%15s|%20s|%10s|%20s%n", "ID", "Receipt Date", "Cost", "Quantity", "Publisher");
        for (Book book : bookList) {
            System.out.println(book.showInfo());
        }
    }

    /**
     * Hien thi danh sach sach giao khoa
     */
    public void showTextBook() {
        System.out.format("%10s|%15s|%20s|%10s|%20s|%10s%n", "ID", "Receipt Date", "Cost", "Quantity", "Publisher", "Status");
        for (Book book : bookList) {
            if (book instanceof TextBook) {
                System.out.println(book.toString());
            }
        }
    }

    /**
     * Hien thi danh sach sach tham khao
     */
    public void showReferenceBook() {
        System.out.format("%10s|%15s|%20s|%10s|%20s|%10s%n", "ID", "Receipt Date", "Cost", "Quantity", "Publisher", "Tax");
        for (Book book : bookList) {
            if (book instanceof ReferenceBook) {
                System.out.println(book.toString());
            }
        }
    }
    // Input values
    public int inputId(){
        int id;
        System.out.print("Input id: ");
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
                if (id < 0) {
                    throw new NumberFormatException();
                }
                return id;
            } catch (NumberFormatException e) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    public double inputTax() {
        double tax;
        System.out.print("Input tax: ");
        while (true) {
            try {
                tax = Double.parseDouble(sc.nextLine());
                if (tax < 0) {
                    throw new NumberFormatException();
                }
                return tax;
            } catch (NumberFormatException e) {
                System.out.print("invalid! Input again: ");
            }
        }
    }

    public String inputStatus() {
        System.out.print("Input status: ");
        return sc.nextLine();
    }

    public String inputReceiptDate() {
        System.out.print("Input receipt date: ");
        return sc.nextLine();
    }

    public double inputCost() {
        double cost;
        System.out.print("Input cost: ");
        while (true) {
            try {
                cost = Double.parseDouble(sc.nextLine());
                if (cost < 0) {
                    throw new NumberFormatException();
                }
                return cost;
            } catch (NumberFormatException e) {
                System.out.print("invalid! Input again: ");
            }
        }
    }

    public int inputQuantity() {
        int quantity;
        System.out.print("Input quantity: ");
        while (true) {
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                return quantity;
            } catch (NumberFormatException e) {
                System.out.print("invalid! Input again: ");
            }
        }
    }

    public String inputPublisher() {
        System.out.print("Input publisher: ");
        return sc.nextLine();
    }

    // Gettter && Setter
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

}
