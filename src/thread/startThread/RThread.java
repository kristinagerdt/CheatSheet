package thread.startThread;

public class RThread implements Runnable {
    private String name;

    public RThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(getName() + " has been interrupted");
        }
        System.out.println(getName() + " finished");
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        Thread rThread = new Thread(new RThread("RThread"));
        rThread.start();
        System.out.println("Main thread finished");
        /* Main thread started
           Main thread finished
           RThread started
           RThread finished */
    }
}