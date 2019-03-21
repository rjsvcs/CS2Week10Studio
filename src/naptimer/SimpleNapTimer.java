package naptimer;

import java.util.HashSet;
import java.util.Set;

/**
 * A timer for naptimer. Can be set to delay for a certain number of hours,
 * minutes and seconds. The timer is the Subject in the Observer design
 * pattern: it notifies any registered Observers when a set alarm expires.
 */
public class SimpleNapTimer implements NapTimer, Runnable {
    /**
     * The time at which the alarm will be raised (or 0 if there is no alarm).
     */
    private long alarmTime;

    /**
     * Flag that indicates whether or not the alarm is currently ringing.
     */
    private boolean ringing;

    // OBSERVER PATTERN STUFF

    /**
     * The SimpleNapTimer is the Subject in the Observer Design Pattern.
     * {@link NapTimerObserver} defines the interface for Observers. This set
     * keeps track of the registered Observers.
     */
    private final Set<NapTimerObserver> registeredListeners;

    /**
     * Creates a new {@link SimpleNapTimer}.
     */
    public SimpleNapTimer() {
        registeredListeners = new HashSet<>();
        turnOff();
    }

    @Override
    public synchronized boolean isRinging() {
        return ringing;
    }

    @Override
    public synchronized void turnOff() {
        ringing = false;
        alarmTime = 0;
        notify();
    }

    @Override
    public synchronized void setAlarm(int delayInSeconds) {
        alarmTime = System.currentTimeMillis() + (delayInSeconds * 1000);
        ringing = false;
        notify();
    }

    /**
     * The {@link SimpleNapTimer SimpleNapTimer's} standard loop. If no alarm has been
     * set, it waits for the alarm to be set. Otherwise, it counts down by
     * seconds until the delay elapses. Once the delay time elapses, the alarm
     * is raised and any observers are notified.
     */
    @Override
    public synchronized void run() {
        while(true) {
            // waits until the alarm has actually been set
            while(ringing || alarmTime <= System.currentTimeMillis()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }

            // waits until the alarm time has expired
            while(System.currentTimeMillis() < alarmTime) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    // squash
                }
            }

            // if the alarm has been set (as opposed to turned off), raises
            // the alarm
            if(alarmTime > 0) {
                // set the alarm to ring
                ringing = true;

                // OBSERVER STUFF: notify listeners
                NapTimerEvent event = new NapTimerEvent(this, alarmTime);
                for(NapTimerObserver listener : registeredListeners) {
                    listener.alarmRaised(event);
                }
            }
        }
    }

    // OBSERVER PATTERN STUFF

    /**
     * The SimpleNapTimer is the Subject in the Observer Design Pattern.
     * {@link NapTimerObserver} defines the interface for the Observer in the
     * pattern. This method registers a NapTimerObserver to be notified when
     * the alarm is raised.
     *
     * The {@link NapTimerObserver} that should be notified when the alarm
     * is raised on this {@link SimpleNapTimer}.
     */
    public void registerNapTimerObserver(NapTimerObserver listener) {
        registeredListeners.add(listener);
    }

    /**
     * Deregisters a {@link NapTimerObserver} so that it will no longer be
     * notified when the alarm is raised on this SimpleNapTimer (see
     * {@link #registerNapTimerObserver(NapTimerObserver)}).
     *
     * @param listener The {@link NapTimerObserver} that should be
     *                 deregistered.
     */
    public void deregisterNapTimerObserver(NapTimerObserver listener) {
        registeredListeners.remove(listener);
    }
}
