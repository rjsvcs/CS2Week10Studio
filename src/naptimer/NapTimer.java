package naptimer;

import java.util.HashSet;
import java.util.Set;

/**
 * A timer for naptimer. Can be set to delay for a certain number of hours,
 * minutes and seconds. The timer is the Subject in the Observer design
 * pattern: it notifies any registered Observers when a set alarm expires.
 */
public class NapTimer implements Runnable {
    /**
     * A constant used to convert seconds to milliseconds.
     */
    private static final long SECOND = 1000;

    /**
     * A constant used to convert minutes to milliseconds.
     */
    private static final long MINUTE = SECOND * 60;

    /**
     * A constant used to convert hours to milliseconds.
     */
    private static final long HOUR = MINUTE * 60;

    /**
     * The initial delay to which the most recent alarm was set.
     */
    private long initialDelay;

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
     * The NapTimer is the Subject in the Observer Design Pattern.
     * {@link NapTimerObserver} defines the interface for Observers. This set
     * keeps track of the registered Observers.
     */
    private final Set<NapTimerObserver> registeredListeners;

    /**
     * Creates a new {@link NapTimer}.
     */
    public NapTimer() {
        registeredListeners = new HashSet<>();
        turnOff();
    }

    /**
     * Used to check to see if the alarm is currently going off.
     *
     * @return True if the alarm is ringing, false otherwise.
     */
    public synchronized boolean isRinging() {
        return ringing;
    }

    /**
     * Turns the alarm off.
     */
    public synchronized void turnOff() {
        ringing = false;
        alarmTime = 0;
        initialDelay = 0;
        notify();
    }

    /**
     * Sets the alarm to the specified delay.
     *
     * @param hours The number of hours to delay the alarm.
     * @param minutes The number of seconds to delay the alarm.
     * @param seconds The number of minutes to delay the alarm.
     */
    public synchronized void setAlarm(int hours, int minutes, int seconds) {
        this.initialDelay = hours * HOUR + minutes * MINUTE + seconds * SECOND;
        alarmTime = System.currentTimeMillis() + initialDelay;
        ringing = false;
        notify();
    }

    /**
     * Snoozes the alarm.
     */
    public synchronized void snooze() {
        setAlarm(0, 0, 9);
    }

    /**
     * The {@link NapTimer NapTimer's} standard loop. If no alarm has been
     * set, it waits for the alarm to be set. Otherwise, it counts down by
     * seconds until the delay elapses. Once the delay time elapses, the alarm
     * is raised and any observers are notified.
     */
    @Override
    public synchronized void run() {
        while(true) {
            // check to make sure that the alarm has been set
            while(initialDelay == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }

            while(System.currentTimeMillis() < alarmTime) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    // squash
                }
            }

            if(initialDelay > 0) {
                NapTimerEvent event = new NapTimerEvent(this, initialDelay);
                // set the alarm to ring
                ringing = true;
                // reset alarmTime to 0
                alarmTime = 0;
                // reset the alarm
                initialDelay = 0;

                // notify listeners
                for(NapTimerObserver listener : registeredListeners) {
                    listener.alarmRaised(event);
                }
            }
        }
    }

    // OBSERVER PATTERN STUFF

    /**
     * The NapTimer is the Subject in the Observer Design Pattern.
     * {@link NapTimerObserver} defines the interface for the Observer in the
     * pattern. This method registers a NapTimerObserver to be notified when
     * the alarm is raised.
     *
     * The {@link NapTimerObserver} that should be notified when the alarm
     * is raised on this {@link NapTimer}.
     */
    public void registerNapTimerObserver(NapTimerObserver listener) {
        registeredListeners.add(listener);
    }

    /**
     * Deregisters a {@link NapTimerObserver} so that it will no longer be
     * notified when the alarm is raised on this NapTimer (see
     * {@link #registerNapTimerObserver(NapTimerObserver)}).
     *
     * @param listener The {@link NapTimerObserver} that should be
     *                 deregistered.
     */
    public void deregisterNapTimerObserver(NapTimerObserver listener) {
        registeredListeners.remove(listener);
    }
}
