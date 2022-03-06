package cau3;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestPriority {
    public static void main(String[] args) {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        Task t1 = new Task();
        Task t2 = new Task();
        Task t3 = new Task();
        t1.nhapTask();
        t2.nhapTask();
        t3.nhapTask();
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        // In cac phan tu ra theo do uu tien
        Iterator<Task> itor = queue.iterator();
        while (itor.hasNext()) {
            Task x = itor.next();
            System.out.println(x);
        }

    }
}
