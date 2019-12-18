package stream.methods;

import java.util.Arrays;
import java.util.Collection;

public class Reduce {
    // .reduce((o1, o2) -> o1 + o2)
    // .reduce(Integer::sum)
    // .reduce(Integer::max)
    // .reduce(Integer::min).orElse(Integer.MIN_VALUE)

    public static void main(String[] args) {
        // reduce performs aggregate functions throughout the collection
        // (such as the sum, finding the minimum or maximum value, etc.)
        // returns Optional

        Collection<Integer> collection = Arrays.asList(1, 2, 5, 6, 2, 5, 7, 8);

        // return sum with .reduce
        Integer sum = collection
                .stream()
                .reduce((o1, o2) -> o1 + o2)
                .orElse(0);
        System.out.println("sum = " + sum);

        // return sum with .reduce and sum()
        Integer sumLambda = collection
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("sumLambda = " + sumLambda);

        //old style
        Integer sumOld = 0;
        for (Integer item : collection) {
            sumOld += item;
        }
        System.out.println("sumOld = " + sumOld);

        // return max
        Integer max = collection
                .stream()
                .reduce(Integer::max)
                .orElse(Integer.MAX_VALUE);
        System.out.println("max = " + max);

        // return min
        Integer min = collection
                .stream()
                .reduce(Integer::min)
                .orElse(Integer.MIN_VALUE);
        System.out.println("min = " + min);
    }
}