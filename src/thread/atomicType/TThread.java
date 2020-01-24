package thread.atomicType;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

import static java.time.temporal.ChronoUnit.MILLIS;

public class TThread extends Thread {
    private int nRuns;
    private static AtomicLong count1 = new AtomicLong(0);
    private static AtomicLong count2 = new AtomicLong(0);

    public TThread(int nRuns) {
        this.nRuns = nRuns;
    }

    public static AtomicLong getCount1() {
        return count1;
    }

    public static AtomicLong getCount2() {
        return count2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRuns; i++) {
            putCount1(1);
            putCount2(1);
        }
    }

    private static void putCount1(int number) {
        count1.getAndAdd(number);
    }

    private static void putCount2(int number) {
        count2.getAndAdd(number);
    }

    public static void main(String[] args) {
        TThread[] tThreads = new TThread[1000];
        Instant start = Instant.now();
        for (int i = 0; i < tThreads.length; i++) {
            tThreads[i] = new TThread(1000);
            tThreads[i].start();
        }
        for (TThread tThread : tThreads) {
            try {
                tThread.join();
            } catch (InterruptedException e) {
                System.out.println(tThread.getName() + " has been interrupted");
            }
        }
        Instant stop = Instant.now();
        System.out.println("Counter1=" + TThread.getCount1() + " Counter2=" + TThread.getCount2());
        System.out.println("Time: " + MILLIS.between(start, stop));
    }
}