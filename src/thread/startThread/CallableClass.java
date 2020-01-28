package thread.startThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CallableClass implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //(int)(Math.random() * ((max - min) + 1)) + min
        return (int) (Math.random() * 11) + 10; //10-20;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureList = new ArrayList<>();
        Callable<Integer> callable = new CallableClass();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(callable);
            futureList.add(future);
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        int sum = 0;
        for (Future<Integer> item : futureList) {
            Integer i = item.get();
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nSum=" + sum);
    }
}