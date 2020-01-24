package thread.daemon;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Printer extends Thread {
    private char symbol;
    private int nPrints;

    public Printer(char symbol, int nPrints, String name) {
        super(name);
        this.symbol = symbol;
        this.nPrints = nPrints;
        setDaemon(true); // dies after the main thread finishes working
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        for (int i = 0; i < nPrints; i++) {
            System.out.println(symbol);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " has been interrupted");
            }
        }
        System.out.println(getName() + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Printer printer1 = new Printer('*', 50, "Printer1");
        Printer printer2 = new Printer('&', 50, "Printer2");

        Instant start = Instant.now();
        printer1.start();
        printer2.start();
        try {
            printer1.join(100);
            printer2.join(100);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        Instant finish = Instant.now();
        System.out.println("Time: " + MILLIS.between(start, finish));
        System.out.println("Main thread finished");

        /* Main thread started
           Printer2 started
           &
           Printer1 started
           *
           &
           *
           &
           *
           Time: 201
           Main thread finished */
        // It means that the threads Printer1 and Printer2 are interrupted after completion of work the Main thread,
        // thus we can't see in log: "Printer1 or Printer2 finished"
    }
}