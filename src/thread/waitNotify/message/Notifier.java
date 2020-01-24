package thread.waitNotify.message;

public class Notifier implements Runnable {
    private final Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setMessage(threadName + " has finished");
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " has been interrupted");
        }
        System.out.println(threadName + " finished");
    }
}