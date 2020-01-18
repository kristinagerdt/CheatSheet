package stream;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        // creating unlimited Stream
        Stream<Integer> ints = Stream.iterate(1, i -> i + 1);
        ints.forEach(System.out::println);
    }
}