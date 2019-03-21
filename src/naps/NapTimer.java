package naps;

/**
 * A timer for naps. Can be set to delay for a certain number of hours,
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
     * Creates a new {@link NapTimer}.
     */
    public NapTimer() {
        initialDelay = 0;
        alarmTime = 0;
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
        notify();
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
            if(alarmTime == 0) {
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

            // send event

            // reset alarmTime to 0
            alarmTime = 0;
        }
    }
}
