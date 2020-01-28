package thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CallableInteger implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //(int)(Math.random() * ((max - min) + 1)) + min
        return (int) (Math.random() * 11) + 10; //10-20;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3); // 1
        List<Future<Integer>> futureList = new ArrayList<>(); // 2
        Callable<Integer> callable = new CallableInteger(); // 3
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(callable); // 4
            futureList.add(future); // 5
        }
        pool.shutdown(); // 6
        pool.awaitTermination(10, TimeUnit.SECONDS); // 7

        int sum = 0;
        for (Future<Integer> item : futureList) {
            Integer i = item.get();
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nSum=" + sum);
    }
}