package naptimer;

/**
 * The interface for a class that can be used to set an alarm timer.
 *
 * This is the SubjectInterface in the Observer Design Pattern. It defines the
 * methods to register and deregister Observers that should be notified when
 * an alarm is raised.
 */
public interface NapTimer extends Runnable {
    /**
     * Does the following:
     * <ul>
     *     <li>If the alarm is currently ringing, the ringer is stopped.</li>
     *     <li>If the alarm timer is currently set, disables the alarm.</li>
     *     <li>If neither of the above two conditions is true, has no
     *     effect</li>
     * </ul>
     */
    public void turnOff();

    /**
     * Sets the alarm to go off after the specified number of seconds.
     *
     * @param delayInSeconds The number of seconds to wait before the alarm is
     *                       raised.
     */
    public void setAlarm(int delayInSeconds);

    /**
     * Returns true if the alarm is currently ringing. False otherwise.
     *
     * @return True if the alarm is currently ringing. Otherwise, returns
     * false.
     */
    public boolean isRinging();

    /**
     * Registers the specified {@link NapTimerObserver} to be notified when an
     * alarm is raised by this NapTimer.
     *
     * @param observer The {@link NapTimerObserver} that will observe this
     *                 NapTimer.
     */
    public void registerNapTimerObserver(NapTimerObserver observer);

    /**
     * Deregisters the specified {@link NapTimerObserver} so that it is no
     * longer notified when an alarm is raised  by this NapTimer.
     *
     * @param observer The {@link NapTimerObserver} that should no longer
     *                 observe this NapTimer.
     */
    public void deregisterNapTimerObserver(NapTimerObserver observer);

}
