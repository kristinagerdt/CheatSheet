package thread.lock;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Counter extends Thread {
    private static long count1 = 0;
    private static long count2 = 0;
    private int nRuns;

    private static ReentrantLock lock = new ReentrantLock();

    public Counter(int nRuns) {
        this.nRuns = nRuns;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRuns; i++) {
            putCount1(1);
            putCount2(1);
        }
    }

    private void putCount1(int number) {
        lock.lock();
        try {
            count1 += number;
        } finally {
            lock.unlock();
        }
    }

    private void putCount2(int number) {
        lock.lock();
        try {
            count2 += number;
        } finally {
            lock.unlock();
        }
    }

    public static long getCount1() {
        return count1;
    }

    public static long getCount2() {
        return count2;
    }

    public static void main(String[] args) {
        Counter[] counters = new Counter[1000];
        Instant start = Instant.now();
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new Counter(1000);
            counters[i].start();
        }
        for (Counter counter : counters) {
            try {
                counter.join();
            } catch (InterruptedException e) {
                System.out.println(counter.getName() + " has been interrupted");
            }
        }
        Instant stop = Instant.now();
        System.out.println("Counter1=" + Counter.getCount1() + " Counter2=" + Counter.getCount2());
        System.out.println("Time: " + MILLIS.between(start, stop));
    }
}