package naptimer;

/**
 * An event indicating that a {@link NapTimer NapTimer's} alarm has gone off.
 * This is the EventObject in the Observer design pattern. It is used by the
 * Subject to notify any registered Observers when an alarm has expired.
 */
public class NapTimerEvent {
    /**
     * The {@link NapTimer} that has raised the alarm.
     */
    private final NapTimer timer;

    /**
     * The initial delay that was set on the {@link NapTimer}.
     */
    private final long alarmTime;

    /**
     * Creates a new {@link NapTimerEvent} with the specified alarm and delay.
     *
     * @param timer The {@link NapTimer} that has raised an alarm.
     * @param alarmTime The time that the alarm was raised (in milliseconds).
     */
    public NapTimerEvent(NapTimer timer, long alarmTime) {
        this.timer = timer;
        this.alarmTime = alarmTime;
    }

    /**
     * Returns the {@link NapTimer} that raised the alarm.
     *
     * @return The {@link NapTimer} that raised the alarm.
     */
    public NapTimer getNapTimer() {
        return timer;
    }

    /**
     * Returns the time that the alarm was raised in milliseconds.
     *
     * @return The time that the alarm was raised in milliseconds.
     */
    public long getAlarmTime() {
        return alarmTime;
    }
}
