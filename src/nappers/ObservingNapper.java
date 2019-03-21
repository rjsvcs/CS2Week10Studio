package nappers;

import naptimer.SimpleNapTimer;
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
        SimpleNapTimer timer = new SimpleNapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        ObservingNapper napper = new ObservingNapper();
        timer.registerNapTimerObserver(napper);

        timer.setAlarm(10);

        new Thread(napper).start();

    }
}
