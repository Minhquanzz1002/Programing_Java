package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 319; ) {
            LocalDate randomDate = createRandomDate(2022, 2022);
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            long a = getRandomTime();
            Date dNow = new Date(a);
            SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat ft2 = new SimpleDateFormat("HH");
            String output = ft2.format(dNow);
            int c = Integer.valueOf(output);
            if (c > 2 && c < 8){
                continue;
            }
            System.out.println(randomDate.format(formatter) + " " + ft.format(dNow));
            i++;

//            String input = "23/12/2014 10:22:12 PM";
//            String input = randomDate + " " + ft.format(dNow);
//            //Format of the date defined in the input String
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
//            //Desired format: 24 hour format: Change the pattern as per the need
//            DateFormat outputformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//            Date date = null;
//            String output = null;
//            try{
//                //Converting the input String to Date
//                date= df.parse(input);
//                //Changing the format of date and storing it in String
//                output = outputformat.format(date);
//                //Displaying the date
//                System.out.println(output);
//            }catch(ParseException pe){
//                pe.printStackTrace();
//            }
        }

    }
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(10, 23);
        int month = createRandomIntBetween(4, 4);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static long getRandomTime() {
        Calendar time = Calendar.getInstance();
        int day = 1 + random(time.get(Calendar.DAY_OF_MONTH));
        int hour = 1 + random(22);
        int minute = 1 + random(56);
        time.set(Calendar.DAY_OF_MONTH, day);
        time.set(Calendar.HOUR_OF_DAY, hour);
        time.set(Calendar.MINUTE, minute);
        return time.getTimeInMillis();
    }
    public static int random(int n) {
        return (new Random()).nextInt(n);
    }

}
