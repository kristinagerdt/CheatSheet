package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MaxMin {
    // .max(Integer::compareTo)
    // .min(Integer::compareTo)
    // .reduce(0, Integer::max)
    // .reduce(Integer::min);
    // .collect(Collectors.summarizingInt(i -> i)).getMax();
    // .collect(Collectors.summarizingInt(i -> i)).getMin();

    public static void main(String[] args) {
        Integer[] array = {1, 2, 5, 6, 4, 7, 8};
        Collection<Integer> collection = Arrays.asList(array);

        // get the maximum value from collection using .max()
        Integer max = collection
                .stream()
                .max(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
        System.out.println("max = " + max);

        // get the maximum value from collection using .reduce()
        Integer maxReduce = collection
                .stream()
                .reduce(0, Integer::max);
        System.out.println("maxReduce = " + maxReduce);

        // get the maximum value from collection using Collectors
        int maxCollectors = collection
                .stream()
                .collect(Collectors.summarizingInt(i -> i))
                .getMax();
        System.out.println("maxCollectors = " + maxCollectors);

        // get the minimum value from collection using .min()
        Integer min = collection
                .stream()
                .min(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        System.out.println("min = " + min);

        // get the minimum value from collection using .reduce()
        Integer minReduce = collection
                .stream()
                .reduce(Integer::min)
                .get();
        System.out.println("minReduce = " + minReduce);

        // get the minimum value from collection using Collectors
        int minCollectors = collection
                .stream()
                .collect(Collectors.summarizingInt(i -> i))
                .getMin();
        System.out.println("minCollectors = " + minCollectors);
    }
}