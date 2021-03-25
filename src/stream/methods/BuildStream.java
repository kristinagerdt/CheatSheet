package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStream {
    public static void main(String[] args) {
        // best practice
        Collection<Integer> collection = Arrays.asList(4, 5, 7, 6, 1);
        Stream<Integer> streamFromCollection = collection.stream();
        System.out.println("Stream<Integer> from Collection " + streamFromCollection.collect(Collectors.toList()));

        Stream<Integer> parallelStreamFromCollection = collection.parallelStream();
        System.out.println("Parallel Stream<Integer> from Collection " + parallelStreamFromCollection.collect(Collectors.toList()));

        Integer[] array = new Integer[]{4, 5, 7, 8, 9, 6, 1};
        Stream<Integer> streamFromArray = Arrays.stream(array);
        System.out.println("Stream<Integer> from Array " + streamFromArray.collect(Collectors.toList()));

        IntStream streamFromString = "temp".chars();
        System.out.println("IntStream from String " + streamFromString.mapToObj(c -> (char) c).collect(Collectors.toList()));

        IntStream streamFromIntStreamRange = IntStream.range(0, 10);
        System.out.println("IntStream from IntStream.range() " + streamFromIntStreamRange.boxed().collect(Collectors.toList()));

        Stream<Integer> streamFromStreamOf = Stream.of(1, 2, 3, 4);
        System.out.println("Stream<Integer> from IntStream.of() " + streamFromStreamOf.collect(Collectors.toList()));

        Stream<Object> streamFromStreamBuilder = Stream.builder().add("a1").add("a2").add("a3").build();
        System.out.println("Stream<Object> from IntStream.builder() " + streamFromStreamBuilder.collect(Collectors.toList()));

        // creating unlimited Stream
        Stream<String> streamFromStreamGenerate = Stream.generate(() -> "a1").limit(5);
        System.out.println("Stream<String> from IntStream.generate() " + streamFromStreamGenerate.collect(Collectors.toList()));

        System.out.print("Stream<Integer> from IntStream.iterate() ");
        Stream<Integer> infiniteStream = Stream.iterate(1, i -> i + 2);
        List<Integer> integers = infiniteStream
                .limit(10)
                .collect(Collectors.toList());
        integers.forEach(i -> System.out.print(i + " "));
    }
}