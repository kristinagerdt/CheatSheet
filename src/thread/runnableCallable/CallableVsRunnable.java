package thread.runnableCallable;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CallableVsRunnable {
    private static final long N_NUMBERS = 5000;
    private static final int N_THREADS = 1000;

    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> listNumbers = getRandomNumbers();
        getSum(listNumbers);
        getParallelSumRunnable(listNumbers);
        getParallelSumCallable(listNumbers);
    }

    private static void getParallelSumCallable(List<List<Integer>> listNumbers) throws InterruptedException {
        Instant start = Instant.now();
        ExecutorService pool = Executors.newFixedThreadPool(N_THREADS);
        List<Callable<Integer>> callableList = new ArrayList<>(N_THREADS);
        for (List<Integer> list : listNumbers) {
            callableList.add(new ListSumCallable(list));
        }
        List<Future<Integer>> futureList = pool.invokeAll(callableList);
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
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("getParallelSumCallable: " + ChronoUnit.MILLIS.between(start, Instant.now()) + " Result: " + sum);
    }

    private static void getParallelSumRunnable(List<List<Integer>> listNumbers) throws InterruptedException {
        Instant start = Instant.now();
        ExecutorService pool = Executors.newFixedThreadPool(N_THREADS);
        ListSumRunnable[] runnableList = new ListSumRunnable[N_THREADS];
        int index = 0;
        for (List<Integer> list : listNumbers) {
            runnableList[index] = new ListSumRunnable(list);
            pool.submit(runnableList[index]);
            index++;
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        int sum = Arrays.stream(runnableList)
                .mapToInt(ListSumRunnable::getSum)
                .sum();

        System.out.println("getParallelSumRunnable: " + ChronoUnit.MILLIS.between(start, Instant.now()) + " Result: " + sum);
    }

    private static void getSum(List<List<Integer>> listNumbers) {
        Instant start = Instant.now();
        int sum = listNumbers
                .stream()
                .flatMap(List::stream)
                .mapToInt(i -> i)
                .sum();
        System.out.println("getSum: " + ChronoUnit.MILLIS.between(start, Instant.now()) + " Result: " + sum);
    }

    private static List<List<Integer>> getRandomNumbers() {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < N_THREADS; i++) {
            List<Integer> list = getRandomList();
            res.add(list);
        }
        return res;
    }

    private static List<Integer> getRandomList() {
        return new Random()
                .ints(N_NUMBERS)
                .boxed()
                .collect(Collectors.toList());
    }
}