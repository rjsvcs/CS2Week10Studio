package clock;

/**
 * The interface that must be implemented by any class that should be notified
 * when a {@link TickEvent} has occurred. This is the Observer Interface in
 * the Observer design pattern.
 */
public interface ClockWatcher {
    /**
     * Called when an observed Clock ticks.
     *
     * @param event Called when an observed Clock ticks.
     */
    void handleTick(TickEvent event);
}
