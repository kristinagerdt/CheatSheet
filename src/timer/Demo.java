package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Demo {

    public static void main(String[] args) {
        try {
            timer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void timer() throws InterruptedException {
        TimerTask messageTask = new TimerTask() {
            public void run() {
                System.out.println("Repeating actions");
            }
        };

        Timer timer = new Timer("Timer");
        timer.schedule(messageTask, 0, 100);
        Thread.sleep(1000 * 2);
        timer.cancel();
    }
}