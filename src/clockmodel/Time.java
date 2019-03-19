package clockmodel;

import java.util.Calendar;

public class Time {
    private final Calendar calendar;

    public Time(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutes() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getSeconds() {
        return calendar.get(Calendar.SECOND);
    }
}
