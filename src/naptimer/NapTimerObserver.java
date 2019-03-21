package naptimer;

/**
 * The interface implemented by any class that should be notified when a
 * {@link SimpleNapTimer} has raised an alarm.
 *
 * This is the Observer interface in the Observer design pattern.
 */
public interface NapTimerObserver {

    /**
     * Called when an observed {@link SimpleNapTimer} raises an alarm.
     *
     * @param event The {@link NapTimerEvent} signifying that an alarm has
     *              been raised by a {@link SimpleNapTimer} that is being observed
     *              by the listener. Indicates which timer raised the alarm
     *              and the time that the alarm was raised (in milliseconds).
     */
    public void alarmRaised(NapTimerEvent event);
}
