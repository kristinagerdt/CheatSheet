package optional;

// Optional - the fight with NullPointerException

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9));

        Optional<Integer> result = getFirstItemMoreThan(integers, 3);
        if (result.isPresent()) {
            System.out.println(result.get());
        }

        result.ifPresent(System.out::println);

        Integer value = result.orElse(0);
        System.out.println("value=" + value);
    }

    private static Optional<Integer> getFirstItemMoreThan(List<Integer> input, int number) {
        for (Integer item : input) {
            if (item > number) {
                return Optional.of(item);
            }
        }
        // null in a Box, Optional<null>
        return Optional.empty();

        // 0 in a Box, Optional<0>
        // return Optional.of(0);

        // item in a Box, Optional<item> or Optional<>
        // return Optional.ofNullable(item);

        // It means that we put down the result in a Box (Optional<result>) and inside can be a value or null,
        // on the client side it's necessary to check what is inside
    }
}