package cau3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CapKhieuVu {
    private int thuTuCap;
    private Queue<Person> cap;

    CapKhieuVu() {
        cap = new LinkedList<>();
    }

    public void themDon(int thuTuCap) {
        System.out.println("--------------------------------------------------");
        System.out.println("Moi nhap thong tin cap tham gia.");
        this.thuTuCap = thuTuCap + 1;
        Person person = new Person();
        person.nhap();
        cap.add(person);
    }

    public void themDoi(int thuTuCap) {
        System.out.println("--------------------------------------------------");
        System.out.println("Moi nhap thong tin nguoi tham gia.");
        this.thuTuCap = thuTuCap + 1;
        Person person1 = new Person();
        Person person2 = new Person();
        person1.nhap();
        cap.add(person1);
        person2.nhap();
        cap.add(person2);
    }

    // Getter && Setter
    public int getThuTuCap() {
        return thuTuCap;
    }

    public void setThuTuCap(int thuTuCap) {
        this.thuTuCap = thuTuCap + 1;
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
            Person x = itor.next();
            result += String.format("%-10d|", thuTuCap) + x.toString() + "\n";
        }
        return result;
    }
}
