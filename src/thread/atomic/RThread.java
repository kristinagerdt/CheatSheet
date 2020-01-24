package thread.atomic;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;

public class RThread implements Runnable {
    private static long count1 = 0;
    private static long count2 = 0;
    private static final Object monitor = new Object();
    private int nRuns;

    public RThread(int nRuns) {
        this.nRuns = nRuns;
    }

    public static long getCount1() {
        return count1;
    }

    public static long getCount2() {
        return count2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRuns; i++) {
            putCount1(1);
            putCount2(1);
        }
    }

    // private synchronized void
    private static void putCount1(int number) {
        synchronized (monitor) {
            count1 += number;
        }
    }

    // private synchronized void
    private synchronized static void putCount2(int number) {
        synchronized (monitor) {
            count2 += number;
        }
    }

    public static void main(String[] args) {
        Thread[] rThreads = new Thread[1000];
        Instant start = Instant.now();
        for (int i = 0; i < rThreads.length; i++) {
            rThreads[i] = new Thread(new RThread(1000), "RThread " + i);
            rThreads[i].start();
        }
        for (Thread rThread : rThreads) {
            try {
                rThread.join();
            } catch (InterruptedException e) {
                System.out.println(rThread.getName() + " has been interrupted");
            }
        }
        Instant stop = Instant.now();
        System.out.println("Counter1=" + RThread.getCount1() + " Counter2=" + RThread.getCount2());
        System.out.println("Time: " + MILLIS.between(start, stop));
    }
}