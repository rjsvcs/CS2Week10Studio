package naps;

public class ObservingNapper implements NapTimerObserver {
    public ObservingNapper() {
        System.out.println("Is sleeping peacefully...");
    }

    @Override
    public synchronized void alarmRaised(NapTimerEvent event) {
        System.out.println("An alarm went off: " + event.getInitialDelay());
        System.out.println("I'm awake!");
        notify();
    }

    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        int seconds = 10;

        NapTimer timer = new NapTimer();
        Thread thread = new Thread(timer);
        thread.setDaemon(true);
        thread.start();

        ObservingNapper napper = new ObservingNapper();
        timer.registerNapTimerObserver(napper);

        timer.setAlarm(hours, minutes, seconds);

        // the main thread needs to wait until the napper is awake
        synchronized(napper) {
            try {
                napper.wait();
            } catch (InterruptedException e) {
                // squash
            }
        }
    }
}
