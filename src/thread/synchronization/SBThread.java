package thread.synchronization;

// Synchronized Block Thread
public class SBThread implements Runnable {
    private final Resource resource;

    public SBThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.setX(1);
            String threadName = Thread.currentThread().getName();
            for (int i = 1; i < 5; i++) {
                int x = resource.getX();
                System.out.println(threadName + " " + x);
                resource.setX(++x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " has been interrupted");
                }
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i = 1; i < 5; i++) {
            Thread sbThread = new Thread(new SBThread(resource));
            sbThread.setName("SBThread " + i);
            sbThread.start();
        }
    }
}

class Resource {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}