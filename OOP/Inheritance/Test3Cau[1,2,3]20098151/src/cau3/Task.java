package cau3;

import java.util.Scanner;

public class Task implements Comparable<Task> {
    public static Scanner sc = new Scanner(System.in);
    private String description;
    private int priority;
    private int doPhucTap;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDoPhucTap() {
        return doPhucTap;
    }

    public void setDoPhucTap(int doPhucTap) {
        this.doPhucTap = doPhucTap;
    }

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public Task() {
        super();
    }

    public String toString() {
        return "Task [description=" + description + ",priority=" + priority + "dophuctap=" + doPhucTap + "]";
    }

    @Override
    public int compareTo(Task arg0) {
        if (this.priority > arg0.priority)
            return -1;
        else if (this.priority < arg0.priority)
            return 1;
        else{
            return this.doPhucTap > arg0.doPhucTap ? 1 : 0;
        }
    }

    public String inputDescription() {
        System.out.print("Nhap mo ta cong viec: ");
        return sc.nextLine();
    }

    public int inputPriority() {
        int priority;
        System.out.print("Nhap do uu tien: ");
        while (true) {
            try {
                priority = Integer.parseInt(sc.nextLine());
                if (priority < 0) {
                    throw new NumberFormatException();
                }
                return priority;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai do uu tien: ");
            }
        }
    }
    
    public int inputDoPhucTap() {
        int doPhucTap;
        System.out.print("Nhap do phuc tap: ");
        while (true) {
            try {
                doPhucTap = Integer.parseInt(sc.nextLine());
                if (doPhucTap < 0) {
                    throw new NumberFormatException();
                }
                return doPhucTap;
            } catch (NumberFormatException e) {
                System.out.print("Nhap loi! Hay nhap lai do uu tien: ");
            }
        }
    }
    public void nhapTask() {
        this.description = inputDescription();
        this.priority = inputPriority();
        this.doPhucTap = inputDoPhucTap();
    }
}
