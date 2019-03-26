package clock;

/**
 * The interface that must be implemented by a {@link Clock}. This is the
 * Subject Interface in the Observer Design Pattern.
 */
public interface Clock {
    /**
     * Allows a {@link ClockWatcher} to register to be notified when the
     * Clock ticks.
     *
     * @param observer The {@link ClockWatcher} that should be notified when
     *                 the Clock ticks.
     */
    void register(ClockWatcher observer);

    /**
     * Deregisters the specified {@link ClockWatcher} so that it is no longer
     * notified when the Clock ticks.
     *
     * @param observer The {@link ClockWatcher} that should no longer be
     *                 notified when the {@link Clock} ticks.
     */
    void deregister(ClockWatcher observer);
}
