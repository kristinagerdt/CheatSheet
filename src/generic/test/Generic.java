package generic.test;

import java.util.Arrays;
import java.util.List;

public class Generic {
    public static double sumOfList(List<? extends Number> values) {
        if (values != null) {
            return values
                    .stream()
                    .map(Number::doubleValue)
                    .reduce(0.0, Double::sum);
        }
        return 0.0;
    }

    public static <T extends Comparable<T>> long countGreaterThan(T[] array, T number) {
        return Arrays
                .stream(array)
                .filter(i -> i.compareTo(number) > 0)
                .count();
    }
}