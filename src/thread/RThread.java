package thread;

public class RThread implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(threadName + " has been interrupted");
        }
        System.out.println(threadName + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Thread rThread = new Thread(new RThread(), "RThread");
        rThread.start();
        System.out.println("Main thread finished");
        /* Main thread started
           Main thread finished
           RThread started
           RThread finished */
    }
}