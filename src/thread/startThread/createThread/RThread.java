package thread.startThread.createThread;

public class RThread implements Runnable {
    private String name;

    public RThread() {
    }

    public RThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        if (name != null) System.out.println("method run() " + getName());
        else System.out.println("method run() " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        thread();
        threadArray();
    }

    private static void thread() {
        Thread thread = new Thread(new RThread(RThread.class.getName()));
        thread.start();
    }

    private static void threadArray() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RThread(), RThread.class.getName() + " " + i);
            threads[i].start();
        }
    }
}