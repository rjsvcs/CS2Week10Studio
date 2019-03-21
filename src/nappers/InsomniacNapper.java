package nappers;

import naptimer.NapTimer;

/**
 * A napper that wakes up every second to see if the alarm on its
 * {@link NapTimer} has been raised yet, and if not, goes back to sleep. An
 * example of polling.
 */
public class InsomniacNapper implements Runnable {
    /**
     * The {@link NapTimer} being used to wake the napper.
     */
    private final NapTimer timer;

    /**
     * Creates a new InsomniacNapper with the specified {@link NapTimer}.
     *
     * @param timer The {@link NapTimer} used to wake this napper up.
     */
    public InsomniacNapper(NapTimer timer) {
        this.timer = timer;
    }

    /**
     * Checks to see if the alarm has started ringing once every second. This
     * results in lots of lost sleep!
     */
    @Override
    public void run() {
        while(!timer.isRinging()) {
            System.out.println("Woke up...alarm not ringing...going back " +
                    "to sleep...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }
        }
        System.out.println("ALARM IS RINGING! I'M AWAKE!");
    }

    /**
     * Creates a new {@link NapTimer} and InsomniacNapper. The sleeper polls
     * to check to see if the alarm has gone off.
     *
     * @param args The
     */
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        int seconds = 4;

        NapTimer timer = new NapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        timer.setAlarm(hours, minutes, seconds);

        new Thread(new InsomniacNapper(timer)).start();
    }
}
