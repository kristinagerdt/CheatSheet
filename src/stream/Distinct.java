package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
    public static void main(String[] args) {
        // distinct
        // the order is guaranteed
        Collection<String> collection = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        List<String> collectionWithoutReplays = collection
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collectionWithoutReplays = " + collectionWithoutReplays);

        // *the same result with using Set. Create Set on base an existing collection
        // the order is not guaranteed
        Collection<String> unOrderedCollection = new HashSet<>(collection);
        System.out.println("collectionWithoutReplaysSet = " + unOrderedCollection);
    }
}