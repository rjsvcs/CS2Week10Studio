package clock;

import java.util.Calendar;

/**
 * An event indicating that a {@link Clock} has ticked.
 */
public class TickEvent {
    /**
     * The format used for the time string; hours, minutes, seconds.
     */
    private static final String TIME_FORMAT = "%02d:%02d:%02d";

    /**
     * The {@link Clock} that generated the TickEvent.
     */
    private final Clock source;

    /**
     * The {@link Calendar} indicating the time at which the TickEvent
     * occurred.
     */
    private final Calendar time;

    /**
     * Creates a new {@link TickEvent} with the specified source {@link Clock}
     * and {@link Calendar} time.
     *
     * @param source The {@link Clock} that generated the TickEvent.
     * @param time The {@link Calendar} indicating the time at which the
     *             TickEvent occurred.
     */
    public TickEvent(Clock source, Calendar time) {
        this.source = source;
        this.time = time;
    }

    /**
     * Returns the {@link Clock} that generated the TickEvent.
     * @return The {@link Clock} that generated the TickEvent.
     */
    public Clock getSource() {
        return source;
    }

    /**
     * Returns the time in the format HH:MM:SSXM (hours, minutes, seconds,
     * and AM or PM) at which the TickEvent was generated.
     * @return The precise time at which the TickEvent was generated as a
     * String.
     */
    public String getTimeString() {
        String amOrPm = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        return String.format(TIME_FORMAT, time.get(Calendar.HOUR),
                time.get(Calendar.MINUTE), time.get(Calendar.SECOND)) + amOrPm;
    }
}
