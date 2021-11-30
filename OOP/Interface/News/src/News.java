import java.util.Scanner;
/**
 * @author @Minhquanzz1002
 */
public class News implements INews {
    public static Scanner sc = new Scanner(System.in);
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rateList;

    public News() {
        rateList = new int[3];
    }

    /**
     * Nhap 3 phan tu cho rate list
     */
    public void inputRateList() {
        for (int i = 0; i < 3;) {
            try {
                System.out.print("Input rate " + (i + 1) + ": ");
                rateList[i] = Integer.parseInt(sc.nextLine());
                if (rateList[i] < 0) {
                    throw new NumberFormatException();
                }
                i++;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai: ");
            }
        }
    }

    /**
     * Khoi tao voi du lieu nhap
     * @param id Bang phan tu size cua list
     */
    public News(int id) {
        this.id = id;
        this.title = inputTitle();
        this.publishDate = inputpublishDate();
        this.author = inputAuthor();
        this.content = inputContent();
        this.rateList = new int[3];
        inputRateList();
    }

    // Inputs
    public String inputTitle() {
        System.out.print("Input title: ");
        return sc.nextLine();
    }

    public String inputpublishDate() {
        System.out.print("Input publish date: ");
        return sc.nextLine();
    }

    public String inputAuthor() {
        System.out.print("Input author: ");
        return sc.nextLine();
    }

    public String inputContent() {
        System.out.print("Input content: ");
        return sc.nextLine();
    }

    /**
     * tinh trung binh rate
     */
    public void calculate() {
        this.averageRate = (float) (rateList[0] + rateList[1] + rateList[2]) / 3f;
    }

    @Override
    public void display() {
        System.out.format("%3d|%15s|%15s|%15s|%15s", id, title, publishDate, author, content);
    }

    // Getter && Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

}
