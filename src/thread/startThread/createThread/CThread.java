package thread.startThread.createThread;

import java.util.concurrent.*;

public class CThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return (int) (Math.random() * 11) + 10; //10-20
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int capacity = 10;
        ExecutorService pool = Executors.newFixedThreadPool(capacity);
        Future<Integer>[] futures = new Future[capacity];

        for (int i = 0; i < capacity; i++) {
            futures[i] = pool.submit(new CThread());
        }

        for (Future<Integer> f : futures) {
            System.out.println(f.get().intValue());
        }

        pool.shutdown();
    }
}