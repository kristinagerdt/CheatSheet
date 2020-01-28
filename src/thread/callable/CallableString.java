package thread.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CallableString implements Callable<Integer> {
    private String word;

    public CallableString(String word) {
        this.word = word;
    }

    @Override
    public Integer call() {
        return word.length();
    }

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("aaa", "bbbb", "cc");
        ExecutorService pool = Executors.newFixedThreadPool(3); // 1
        List<Future<Integer>> futureList = new ArrayList<>(); // 2
        for (String word : collection) {
            Callable<Integer> callable = new CallableString(word); // 3
            Future<Integer> future = pool.submit(callable); // 4
            futureList.add(future); // 5
        }
        pool.shutdown(); // 6
        try {
            pool.awaitTermination(10, TimeUnit.SECONDS); // 7
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = futureList
                .stream()
                .mapToInt(i -> {
                    try {
                        return i.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        return 0;
                    }
                })
                .sum();
        System.out.println("Sum=" + sum);
    }
}