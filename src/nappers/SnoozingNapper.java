package nappers;

import naptimer.NapTimer;
import naptimer.SimpleNapTimer;
import naptimer.NapTimerEvent;
import naptimer.NapTimerObserver;

/**
 * A napper that observes a {@link NapTimer} but snoozes the alarm three times
 * before rousing from sleep.
 *
 * This is a ConcreteObserver in the ObserverDesignPattern.
 */
public class SnoozingNapper implements NapTimerObserver {
    /**
     * Used to count the number of remaining snoozes.
     */
    private int snoozes;

    /**
     * The {@link NapTimer} used to nap.
     */
    private NapTimer timer;

    /**
     * Sets the {@link NapTimer NapTimer's} alarm for the specified duration
     * in seconds before going to sleep.
     *
     * @param timer The {@link NapTimer} that will rouse the napper from sleep
     *              when it raises an alarm.
     * @param durationInSeconds The duration of the nap.
     */
    public synchronized void goToSleep(NapTimer timer, int durationInSeconds) {
        this.timer = timer;
        snoozes = 3;

        timer.registerNapTimerObserver(this);
        timer.setAlarm(durationInSeconds);
        System.out.println("Snoozer is sleeping peacefully.");
        try {
            wait();
        } catch (InterruptedException e) {
            // squash
        }
        System.out.println("Snoozer says: OK, OK, I'm awake." );
        timer.turnOff();
        timer.deregisterNapTimerObserver(this);

    }

    /**
     * Rouses the napper from sleep, but if the napper has not yet snoozed
     * three times, it will hit the snooze button.
     *
     * @param event The {@link NapTimerEvent} signifying that an alarm has
     *              been raised by a {@link NapTimer} that is being observed
     *              by the listener. Indicates which timer raised the alarm
     */
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

        SnoozingNapper napper = new SnoozingNapper();
        napper.goToSleep(timer, 5);
    }
}
