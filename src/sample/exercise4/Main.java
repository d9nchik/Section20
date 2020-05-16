package sample.exercise4;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<GregorianCalendar> gregorianCalendars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(new Date(random.nextLong()));
            gregorianCalendars.add(gregorianCalendar);
        }

        gregorianCalendars.sort(new GregorianCalendarComparator());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        gregorianCalendars.forEach(e-> System.out.println(simpleDateFormat.format(e.getTime())));
    }
}
