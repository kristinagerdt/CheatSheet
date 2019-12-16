package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkip {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // return the first two elements
        List<String> firstTwoItems = collection
                .stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("firstTwoItems = " + firstTwoItems);

        // return two items starting from the second
        List<String> twoItemsFromSecondPosition = collection
                .stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("twoItemsFromSecondPosition = " + twoItemsFromSecondPosition);

        // return the last item of collection
        String last = collection
                .stream()
                .skip(collection.size() - 1)
                .findFirst() // .findAny
                .orElse("last");
        System.out.println("last = " + last);
    }
}