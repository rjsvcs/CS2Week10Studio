package nappers;

import naptimer.NapTimer;
import naptimer.NapTimerEvent;
import naptimer.NapTimerObserver;

public class ObservingNapper implements Runnable, NapTimerObserver {
    public ObservingNapper() {
        System.out.println("Is sleeping peacefully...");
    }

    @Override
    public synchronized void alarmRaised(NapTimerEvent event) {
        System.out.println("An alarm went off: " + event.getAlarmTime());
        notify();
    }

    public synchronized void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            // squash
        }
        System.out.println("Observer says: I'm awake! I'm awake!");
    }

    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        int seconds = 10;

        NapTimer timer = new NapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        ObservingNapper napper = new ObservingNapper();
        timer.registerNapTimerObserver(napper);

        timer.setAlarm(hours, minutes, seconds);

        new Thread(napper).start();

    }
}
