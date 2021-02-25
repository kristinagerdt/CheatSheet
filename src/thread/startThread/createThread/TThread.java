package thread.startThread.createThread;

import java.util.Random;

public class TThread extends Thread {
    public TThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("method run() " + getName());
    }

    public static void main(String[] args) {
        thread();
        threadArray();
    }

    private static void thread() {
        System.out.println("Main thread started");
        TThread tThread = new TThread(TThread.class.getName());
        tThread.start();
    }

    private static void threadArray() {
        Random random = new Random();
        TThread[] threads = new TThread[random.nextInt(10)];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new TThread(TThread.class.getName() + " " + i);
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(threads[i].getName() + " has been interrupted");
            }
        }
        System.out.println("Main thread finished");
    }
}