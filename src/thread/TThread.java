package thread;

public class TThread extends Thread {
    public TThread(String name) {
        super(name);
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
        // 1. Main thread finished earlier than child thread TThread
        // System.out.println("Main thread started");
        // for (int i = 0; i < 2; i++) {
        //      new TThread("TThread " + i).start();
        // }
        // System.out.println("Main thread finished");
        /* Main thread started
           Main thread finished
           TThread 0 started
           TThread 1 started
           TThread 0 finished
           TThread 1 finished */

        // 2. Main thread finished after child thread TThread
        System.out.println("Main thread started");
        TThread tThread = new TThread("TThread");
        tThread.start();
        try {
            tThread.join();
        } catch (InterruptedException e) {
            System.out.println(tThread.getName() + " has been interrupted");
        }
        System.out.println("Main thread finished");
        /* Main thread started
           TThread started
           TThread finished
           Main thread finished */
    }
}