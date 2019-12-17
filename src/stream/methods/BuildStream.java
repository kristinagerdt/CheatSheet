package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStream {
    public static void main(String[] args) {
        // best practice
        Collection<Integer> collection = Arrays.asList(4, 5, 7, 6, 1);
        Stream<Integer> streamFromCollection = collection.stream();
        // System.out.println(streamFromCollection.collect(Collectors.toList()));
        Stream<Integer> parallelStreamFromCollection = collection.parallelStream();

        Integer[] array = new Integer[]{4, 5, 7, 8, 9, 6, 1};
        Stream<Integer> streamFromArray = Arrays.stream(array);

        IntStream streamFromString = "temp".chars();

        IntStream streamOfIntStream = IntStream.range(0, 10);

        Stream<Integer> streamFromValues = Stream.of(1, 2, 3, 4);

        Stream.builder().add("a1").add("a2").add("a3").build();

        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
    }
}