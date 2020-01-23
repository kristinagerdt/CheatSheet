package thread;

public class RThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finished");
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