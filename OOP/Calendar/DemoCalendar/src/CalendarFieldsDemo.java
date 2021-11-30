import java.util.*;

public class CalendarFieldsDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // cal.set(2021, 10, 10);
        System.out.println("Year: " + cal.get(Calendar.YEAR));
        System.out.println("Month: " + (cal.get(Calendar.MONTH) + 1));
        System.out.println("Day: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hour: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + cal.get(Calendar.MINUTE));
        System.out.println("Second: " + cal.get(Calendar.SECOND));
        System.out.println("Milli second: " + cal.get(Calendar.MILLISECOND));
    }
}
