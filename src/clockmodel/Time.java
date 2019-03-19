package clockmodel;

import java.util.Calendar;

public class Time {
    private final Calendar calendar;

    public Time(Calendar calendar) {
        this.calendar = calendar;
    }

    public Time(int hours, int minutes, int seconds) {
        this(Calendar.getInstance());
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);
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
