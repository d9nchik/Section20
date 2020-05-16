package sample.exercise4;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class GregorianCalendarComparator implements Comparator<GregorianCalendar>, Serializable {
    @Override
    public int compare(GregorianCalendar o1, GregorianCalendar o2) {
        if (o1.get(Calendar.DATE) != o2.get(Calendar.DATE))
            return Double.compare(o1.get(Calendar.DATE), o2.get(Calendar.DATE));
        if (o1.get(Calendar.YEAR) != o2.get(Calendar.YEAR))
            return Double.compare(o1.get(Calendar.YEAR), o2.get(Calendar.YEAR));
        return Double.compare(o1.get(Calendar.MONTH), o2.get(Calendar.MONTH));
    }
}
