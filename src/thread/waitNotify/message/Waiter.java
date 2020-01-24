package thread.waitNotify.message;

public class Waiter implements Runnable {
    private final Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println(threadName + " waiting for notify");
                message.wait();
            } catch (InterruptedException e) {
                System.out.println(threadName + " has been interrupted");
            }
            System.out.println(threadName + " notified");
            System.out.println(threadName + ": " + message.getMessage());
        }
    }
}