package nappers;

import naptimer.NapTimer;
import naptimer.SimpleNapTimer;

/**
 * A napper that wakes up every second to see if the alarm on its
 * {@link SimpleNapTimer} has been raised yet, and if not, goes back to sleep. An
 * example of polling.
 */
public class InsomniacNapper {

    /**
     * Checks to see if the alarm has started ringing once every second. This
     * results in lots of lost sleep!
     */
    public void goToSleep(NapTimer timer, int durationInSeconds) {
        timer.setAlarm(durationInSeconds);
        System.out.println("Insomniac tries to go to sleep...");
        while(!timer.isRinging()) {
            System.out.println("Insomniac woke up to check the alarm, " +
                    "but it's not ringing yet...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }
        }
        System.out.println("The alarm is going off!");
        System.out.println("Insomniac says: \"Alright. Fine. I'm Up.\"");
        timer.turnOff();
    }

    /**
     * Creates a new {@link SimpleNapTimer} and InsomniacNapper. The sleeper polls
     * to check to see if the alarm has gone off.
     *
     * @param args The
     */
    public static void main(String[] args) {
        NapTimer timer = new SimpleNapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        InsomniacNapper napper = new InsomniacNapper();
        napper.goToSleep(timer, 10);
    }
}
