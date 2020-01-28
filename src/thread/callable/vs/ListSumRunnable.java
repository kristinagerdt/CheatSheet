package thread.callable.vs;

import java.util.List;

public class ListSumRunnable implements Runnable {
    private List<Integer> numbers;
    private int sum;

    public ListSumRunnable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}