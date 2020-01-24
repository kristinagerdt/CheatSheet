package thread.runnableCallable;

import java.util.List;
import java.util.concurrent.Callable;

public class ListSumCallable implements Callable<Integer> {
    private List<Integer> numbers;

    public ListSumCallable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        return numbers
                .stream()
                .reduce(0, Integer::sum);
    }
}