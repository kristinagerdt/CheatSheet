package stream.methods;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SumStatistic {
    // .reduce(0, (a, b) -> a + b);
    // .reduce(0, Integer::sum);
    // .collect(Collectors.summingInt(Integer::intValue));
    // .mapToInt(Integer::intValue).sum();
    // .mapToInt(Integer::valueOf).sum();
    // .mapToInt(i -> i % 2 != 0 ? i : 0).sum;
    // .collect(Collectors.summarizingInt(i -> i % 2 != 0 ? i : 0)).getSum();
    // .collect(Collectors.summingInt(i -> i % 2 != 0 ? i : 0));

    // .collect(Collectors.summarizingInt(i -> i + 3));

    public static void main(String[] args) {
        // collect converts stream to a collection or other data structure
        // Useful static methods from Collectors:
        // toList, toCollection, toSet - represent the stream as a list, collection or set
        // summingInt, summingDouble, summingLong - returns the sum
        // summarizingInt, summarizingDouble, summarizingLong - return SummaryStatistics with different aggregate values

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

        // get the sum of the odd numbers using sum()
        int sumOdd = integers
                .stream()
                .mapToInt(i -> i % 2 != 0 ? i : 0)
                .sum();
        System.out.println("sumOdd=" + sumOdd);

        // get the sum of the even numbers through IntSummaryStatistics
        long sumEven = integers
                .stream()
                .collect(Collectors.summarizingInt(i -> i % 2 != 0 ? i : 0))
                .getSum();
        System.out.println("sumEven = " + sumEven);

        // get the sum of the odd numbers using Collectors.summingInt()
        Integer sumOddSummingInt = integers
                .stream()
                .collect(Collectors.summingInt(i -> i % 2 != 0 ? i : 0));
        System.out.println("sumOddSummingInt=" + sumOddSummingInt);

        // add to numbers 3 and get statistics
        IntSummaryStatistics statistics = integers
                .stream()
                .collect(Collectors.summarizingInt(i -> i + 3));
        System.out.println("statistics = " + statistics);
    }
}