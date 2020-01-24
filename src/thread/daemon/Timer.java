package thread.daemon;

import java.time.LocalTime;

public class Timer extends Thread {
    public Timer(String name) {
        super(name);
        setDaemon(true); // dies after the main thread finishes working
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        for (int i = 0; i < 10; i++) {
            System.out.println(LocalTime.now());
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(getName() + " has been interrupted");
            }
        }
        System.out.println(getName() + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Timer timer = new Timer("Timer");
        timer.start();
        try {
            timer.join(200);
        } catch (InterruptedException e) {
            System.out.println(timer.getName() + " has been interrupted");
        }
        System.out.println("Main thread finished");

        /*  timer.join(1000);
            Main thread started
            Timer started
            18:17:31.064
            18:17:31.088
            18:17:31.098
            18:17:31.108
            18:17:31.118
            18:17:31.129
            18:17:31.139
            18:17:31.149
            18:17:31.160
            18:17:31.171
            Timer finished
            Main thread finished */

        /*  timer.join(200);
            Main thread started
            Timer started
            18:19:19.222
            18:19:19.250
            18:19:19.260
            18:19:19.270
            18:19:19.280
            18:19:19.291
            Main thread finished */
    }
}