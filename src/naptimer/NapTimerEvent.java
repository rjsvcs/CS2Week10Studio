package naptimer;

/**
 * An event indicating that a {@link NapTimer NapTimer's} alarm has gone off.
 *
 * This is the EventObject in the Observer design pattern. It is used by the
 * Subject to notify any registered Observers when an alarm has expired.
 */
public class NapTimerEvent {
    /**
     * The {@link NapTimer} that has raised the alarm.
     */
    private final NapTimer timer;

    /**
     * Creates a new {@link NapTimerEvent} with the specified alarm and time.
     *
     * @param timer The {@link NapTimer} that has raised an alarm.
     */
    public NapTimerEvent(NapTimer timer) {
        this.timer = timer;
    }

    /**
     * Returns the {@link NapTimer} that raised the alarm.
     *
     * @return The {@link NapTimer} that raised the alarm.
     */
    public NapTimer getNapTimer() {
        return timer;
    }
}
