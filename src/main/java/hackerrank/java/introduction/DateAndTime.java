package hackerrank.java.introduction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateAndTime {
    private final static String[] WEEK = {"","SUNDAY", "MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String m = in.next();
        String d = in.next();
        String y = in.next();
        try {
            Date date = new SimpleDateFormat("MMddyyyy").parse(m+d+y);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int day_of_week = c.get(Calendar.DAY_OF_WEEK);
            System.out.println(WEEK[day_of_week]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
