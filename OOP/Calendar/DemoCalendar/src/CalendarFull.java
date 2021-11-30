import java.util.Calendar;

public class CalendarFull {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println("YEAR: " + cal.get(Calendar.YEAR));
        System.out.println("MONTH: " + cal.get(Calendar.MONTH));
        System.out.println("DAY_OF_MONTH: " + cal.get(Calendar.DAY_OF_MONTH)); // return [0, 11]
        System.out.println("DATE: " + cal.get(Calendar.DATE));
        System.out.println("HOUR OF DAY: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("HOUR: " + cal.get(Calendar.HOUR));
        System.out.println("AM PM: " + cal.get(Calendar.AM_PM));
        System.out.println("MINUTE: " + cal.get(Calendar.MINUTE));
        System.out.println("SECOND: " + cal.get(Calendar.SECOND));
        System.out.println("MILLI SECOND: " + cal.get(Calendar.MILLISECOND));
        System.out.println("DAY OF YEAR: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("ZONE OFFSET: " + cal.get(Calendar.ZONE_OFFSET));
        System.out.println("DAY OF WEEK IN MONTH: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    }
}
