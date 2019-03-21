package nappers;

import naptimer.NapTimer;
import naptimer.SimpleNapTimer;
import naptimer.NapTimerEvent;
import naptimer.NapTimerObserver;

/**
 * A napper that observes a {@link NapTimer} waiting for a
 * {@link NapTimerEvent} before rousing from its sleep.
 *
 * This is a ConcreteObserver in the ObserverDesignPattern.
 */
public class ObservingNapper implements NapTimerObserver {
    /**
     * Wakes the sleeper when the {@link NapTimerEvent} is sent.
     *
     * @param event The {@link NapTimerEvent} signifying that an alarm has
     *              been raised by a {@link NapTimer} that is being observed
     *              by the listener. Indicates which timer raised the alarm
     */
    @Override
    public synchronized void alarmRaised(NapTimerEvent event) {
        System.out.println("An alarm went off: " + event.getAlarmTime());
        notify();
    }

    /**
     * Sets the {@link NapTimer NapTimer's} alarm for the specified duration
     * in seconds before going to sleep.
     *
     * @param timer The {@link NapTimer} that will rouse the napper from
     *              sleep when it raises an alarm.
     * @param durationInSeconds The duration of the nap.
     */
    public synchronized void goToSleep(NapTimer timer, int durationInSeconds) {
        timer.registerNapTimerObserver(this);
        timer.setAlarm(durationInSeconds);

        System.out.println("Observer is sleeping peacefully...");
        try {
            wait();
        } catch (InterruptedException e) {
            // squash
        }
        System.out.println("Observer says: I'm awake! I'm awake!");
        timer.turnOff();
        timer.deregisterNapTimerObserver(this);
    }

    public static void main(String[] args) {
        NapTimer timer = new SimpleNapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        ObservingNapper napper = new ObservingNapper();
        napper.goToSleep(timer, 5);
    }
}
