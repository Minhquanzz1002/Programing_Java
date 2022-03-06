package cau3;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CapKhieuVu {
    private int thuTuCap;       // nhung nguoi di chung se co cung so thu tu
    private Queue<Person> cap;  // nguoi hoac cap khieu vu

    CapKhieuVu() {
        cap = new LinkedList<>();
    }

    /**
     * nhap du lieu cho nguoi di khieu vu don
     * @param thuTuCap thu tu den cua nguoi nay
     */
    public void nhapDon(int thuTuCap) {
        System.out.println("--------------------------------------------------");
        System.out.println("Moi nhap thong tin nguoi tham gia.");
        this.thuTuCap = thuTuCap + 1;
        Person person = new Person();
        person.inputPerson();
        cap.add(person);
    }

    /**
     * Nhap du lieu cho cap di khieu vu
     * @param thuTuCap thu tu den cua cap nay
     */
    public void nhapDoi(int thuTuCap) {
        System.out.println("--------------------------------------------------");
        System.out.println("Moi nhap thong tin cap tham gia.");
        this.thuTuCap = thuTuCap + 1;
        Person person1 = new Person();
        Person person2 = new Person();
        person1.inputPerson();
        cap.add(person1);
        person2.inputPerson();
        cap.add(person2);
    }

    // Getter && Setter
    public int getThuTuCap() {
        return thuTuCap;
    }

    public void setThuTuCap(int thuTuCap) {
        this.thuTuCap = thuTuCap;
    }

    public Queue<Person> getCap() {
        return cap;
    }

    public void setCap(Queue<Person> cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        String result = "";
        Iterator<Person> itor = cap.iterator();
        while (itor.hasNext()) {
            result += String.format("%-10d|", thuTuCap) + itor.next().toString() + "\n";
        }
        return result;
    }
}
