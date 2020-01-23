package thread.interruption;

public class RThread implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        int counter = 1; // counter of loops
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Loop " + counter++);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " has been interrupted");
        }
        System.out.println(threadName + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Thread rThread = new Thread(new RThread(), "RThread");
        rThread.start();
        try {
            // the longer the main thread sleeps, the more loops the child thread will execute
            Thread.sleep(100);
            rThread.interrupt();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished");
    }
}