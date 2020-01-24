package thread.deadlock;

public class Demo {
    public static final Object monitor1 = new Object();
    public static final Object monitor2 = new Object();

    public static void main(String[] args) {
        Thread jThread = new JThread();
        Thread xThread = new XThread();
        jThread.start();
        xThread.start();
    }

    private static class JThread extends Thread {
        @Override
        public void run() {
            synchronized (monitor1) {
                System.out.println("JThread: Holds monitor1");
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("JThread: Waits for monitor2");
                synchronized (monitor2) {
                    System.out.println("JThread: Holds monitor2");
                }
            }
        }
    }

    private static class XThread extends Thread {
        @Override
        public void run() {
            synchronized (monitor2) { // for solution deadlock: monitor1
                System.out.println("XThread: Holds monitor2");
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("XThread: Waits for monitor1");
                synchronized (monitor1) { // monitor2
                    System.out.println("XThread: Holds monitor1");
                }
            }
        }
    }
}