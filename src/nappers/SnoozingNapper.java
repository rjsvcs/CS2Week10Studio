package nappers;

import naptimer.SimpleNapTimer;
import naptimer.NapTimerEvent;
import naptimer.NapTimerObserver;

public class SnoozingNapper implements Runnable, NapTimerObserver {
    private final SimpleNapTimer timer;
    private int snoozes;

    public SnoozingNapper(SimpleNapTimer timer) {
        this.timer = timer;
        snoozes = 3;
        timer.registerNapTimerObserver(this);
        System.out.println("Snoozer is sleeping peacefully.");
    }

    public synchronized void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            // squash
        }
        System.out.println("Snoozer says: I'm awake! I'm awake!");
        timer.deregisterNapTimerObserver(this);
    }

    @Override
    public synchronized void alarmRaised(NapTimerEvent event) {
        System.out.println("Alarm goes off!");
        if(snoozes > 0) {
            timer.setAlarm(5);
            System.out.println("Snoozer presses the snooze button...");
            snoozes--;
        } else {
            notify();
        }
    }

    public static void main(String[] args) {
        SimpleNapTimer timer = new SimpleNapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        new Thread(new SnoozingNapper(timer)).start();

        timer.setAlarm(4);
    }
}
