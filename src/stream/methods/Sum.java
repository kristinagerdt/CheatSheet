package stream.methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sum {
    // .reduce(0, (a, b) -> a + b);
    // .reduce(0, Integer::sum);
    // .collect(Collectors.summingInt(Integer::intValue));
    // .mapToInt(Integer::intValue).sum();
    // .mapToInt(Integer::valueOf).sum();

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // get sum using .reduce()
        Integer sum0 = integers.stream()
                .reduce(0, (a, b) -> a + b);

        // get sum using .reduce(Integer::sum)
        Integer sum1 = integers.stream()
                .reduce(0, Integer::sum);

        // get sum using Collectors
        Integer sum2 = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        // get sum using .mapToInt(Integer::intValue)
        Integer sum3 = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // get sum using .mapToInt(Integer::valueOf)
        Integer sum4 = integers
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}