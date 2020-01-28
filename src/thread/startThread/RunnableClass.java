package thread.startThread;

public class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("method run(), " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RunnableClass(), "RunnableClass " + i);
            threads[i].start();
        }
    }
}