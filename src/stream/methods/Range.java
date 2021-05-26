package stream.methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Range {
    public static void main(String[] args) {
        // new knd of loop - IntStream.range(1, 3)

        IntStream range = IntStream.range(1, 3);
        range.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream rangeClosed = IntStream.rangeClosed(1, 3);
        rangeClosed.forEach(i -> System.out.print(i + " "));
        System.out.println();

        Integer[] array = {1, 2, 5, 6, 4, 7, 8};

        // get the smallest divisor into which all elements of the array are not completely divided
        int smallestDiv = IntStream
                .range(2, Arrays.stream(array).max(Integer::compareTo).get() + 2)
                .filter(div -> Arrays.stream(array).allMatch(item -> item % div != 0))
                .min()
                .orElse(1);
        System.out.println("smallestDiv = " + smallestDiv);

        // get the odd IntStream where i % 2 == 0
        IntStream oddIntStream = IntStream
                .range(0, array.length)
                .filter(i -> i % 2 == 0)
                .map(i -> array[i]);
        oddIntStream.forEach(System.out::println);

        // get the new IntStream where new i=i*i
        IntStream newIntStream = IntStream
                .range(1, 5)
                .map(i -> i * i);
        newIntStream.forEach(System.out::println);

        // get the maximum from a range [1,5]
        int max = IntStream
                .rangeClosed(1, 5)
                .max()
                .getAsInt();
        System.out.println("max = " + max);
    }
}