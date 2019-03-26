package clock;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides a concrete implementation of the {@link Clock} interface.
 * Generates a {@link TickEvent} approximately once each second. The Real
 * Subject in the Observer Design Pattern.
 */
public class RealClock implements Clock {
    /**
     * The collection of registered {@link ClockWatcher ClockWatchers}.
     */
    private final Set<ClockWatcher> observers;

    public RealClock() {
        observers = new HashSet<>();

        Thread thread = new Thread(this::tickTock);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void register(ClockWatcher observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(ClockWatcher observer) {
        observers.remove(observer);
    }

    private void tickTock() {
        while(true) {
            TickEvent event = new TickEvent(this, Calendar.getInstance());
            for(ClockWatcher observer : observers) {
                observer.handleTick(event);
            }
            try {
                Thread.sleep(950);
            } catch (InterruptedException e) {
                // squash
            }
        }
    }
}
