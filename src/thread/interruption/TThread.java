package thread.interruption;

public class TThread extends Thread {
    public TThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        int counter = 1; // counter of loops
        try {
            while (!isInterrupted()) {
                System.out.println("Loop " + counter++);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " has been interrupted");
        }
        System.out.println(getName() + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        TThread tThread = new TThread("TThread");
        tThread.start();
        try {
            // the longer the main thread sleeps, the more loops the child thread will execute
            Thread.sleep(100);
            tThread.interrupt();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished");
    }
}