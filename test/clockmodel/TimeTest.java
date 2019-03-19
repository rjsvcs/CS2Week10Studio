package clockmodel;

import clockmodel.Time;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeTest {

    @Test
    public void createWithCurrentDate() {
        Calendar current = Calendar.getInstance();
        Time CuT = new Time(current);

        assertEquals(current.get(Calendar.HOUR_OF_DAY), CuT.getHours());
        assertEquals(current.get(Calendar.MINUTE), CuT.getMinutes());
        assertEquals(current.get(Calendar.SECOND), CuT.getSeconds());

    }

    @Test
    public void createWithHoursMinutesSeconds() {

    }
}