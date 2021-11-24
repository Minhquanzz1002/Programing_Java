/**
 * Student class
 * 
 * @author MinhQuan
 */
public class Student extends Person {
    private float mark1;
    private float mark2;

    public Student() {
    }

    public float getMark1() {
        return mark1;
    }

    public void setMark1(float mark1) {
        this.mark1 = mark1;
    }

    public float getMark2() {
        return mark2;
    }

    public void setMark2(float mark2) {
        this.mark2 = mark2;
    }

    public float calculateAverage() {
        return (mark1 + mark2) / 2;
    }

    /**
     * input student mark
     * 
     * @return mark
     */
    public float inputMark() {
        System.out.print("Input mark: ");
        while (true) {
            try {
                float mark = Float.parseFloat(sc.nextLine());
                if (mark < 0 || mark > 10) {
                    throw new NumberFormatException();
                }
                return mark;
            } catch (NumberFormatException e) {
                System.out.print("invalid! Input mark in again: ");
            }
        }

    }

    @Override
    public String toString() {
        return super.toString() + String.format("%10.2f | %10.2f | %10.2f", mark1, mark2, calculateAverage());
    }
}
