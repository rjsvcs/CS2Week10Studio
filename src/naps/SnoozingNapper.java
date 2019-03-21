package naps;

public class SnoozingNapper implements NapTimerObserver {
    private final NapTimer timer;
    private int snoozes;

    public SnoozingNapper(NapTimer timer) {
        this.timer = timer;
        snoozes = 3;
        System.out.println("Snoozer is sleeping peacefully.");
    }

    @Override
    public void alarmRaised(NapTimerEvent event) {
        if(snoozes > 0) {
            System.out.println("Alarm goes off!");
            timer.snooze();
            System.out.println("Snoozer presses the snooze button...");
            snoozes--;
        } else {
            System.out.println("Snoozer says \"OK, OK, I'm awake!\"");
            timer.deregisterNapTimerObserver(this);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        int seconds = 5;

        NapTimer timer = new NapTimer();
        new Thread(timer).start();

        SnoozingNapper napper = new SnoozingNapper(timer);
        timer.registerNapTimerObserver(napper);

        timer.setAlarm(hours, minutes, seconds);
    }
}
