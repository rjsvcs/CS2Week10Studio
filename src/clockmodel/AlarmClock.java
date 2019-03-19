package clockmodel;

import java.util.Calendar;

public class AlarmClock implements Runnable {

    public AlarmClock() {

    }

    public void setAlarm(int hours, int minutes, int seconds) {

    }

    public Calendar getTime() {
        return Calendar.getInstance();
    }

    @Override
    public void run() {
        boolean sentenel = true;

        while(!sentenel) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                sentenel = false;
            }
        }
    }
}
