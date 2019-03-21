package naps;

/**
 * The interface implemented by any class that should be notified when a
 * {@link NapTimer} has raised an alarm. This is the Observer in the Observer
 * design pattern.
 */
public interface NapTimerListener {
    /**
     * Called when an observed {@link NapTimer} raises an alarm.
     *
     * @param event The {@link NapTimerEvent} signifying that an alarm has
     *              been raised by a {@link NapTimer} that is being observed
     *              by the listener. Indicates which timer raised the alarm
     *              and the original delay to which the timer was set
     *              (in milliseconds).
     */
    public void alarmRaised(NapTimerEvent event);
}