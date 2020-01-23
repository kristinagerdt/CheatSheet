package thread.interruption;

public class RThreadActive implements Runnable {
    private boolean isActive;

    public RThreadActive() {
        this.isActive = true;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        int counter = 1; // counter of loops
        while (isActive) {
            System.out.println("Loop " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(threadName + " has been interrupted");
            }
        }
        System.out.println(threadName + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        RThreadActive rThreadActive = new RThreadActive();
        new Thread(rThreadActive, "RThreadActive").start();
        try {
            // the longer the main thread sleeps, the more loops the child thread will execute
            Thread.sleep(2200);
            rThreadActive.disable();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished");
    }
}