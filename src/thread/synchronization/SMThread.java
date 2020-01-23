package thread.synchronization;

// Synchronized Method Thread
public class SMThread implements Runnable {
    private CommonResource resource;

    public SMThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.increment();
    }

    public static void main(String[] args) {
        CommonResource resource = new CommonResource();
        for (int i = 1; i < 5; i++) {
            Thread smThread = new Thread(new SMThread(resource));
            smThread.setName("SMThread " + i);
            smThread.start();
        }
    }
}

class CommonResource {
    private int x;

    public synchronized void increment() {
        x = 1;
        String threadName = Thread.currentThread().getName();
        for (int i = 1; i < 5; i++) {
            System.out.println(threadName + " " + x);
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(threadName + " has been interrupted");
            }
        }
    }
}