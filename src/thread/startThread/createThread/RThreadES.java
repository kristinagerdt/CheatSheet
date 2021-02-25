package thread.startThread.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RThreadES implements Runnable {
    private final String name;

    public RThreadES(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName());
    }

    public static void main(String[] args) {
        int capacity = 3;
        ExecutorService pool = Executors.newFixedThreadPool(capacity);
        for (int i = 0; i < capacity; i++) {
            pool.execute(new Thread(new RThreadES(RThreadES.class.getName() + ' ' + i)));
        }
        pool.shutdown();
    }
}