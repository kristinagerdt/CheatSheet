package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ForeachPeek {
    // .forEach(s -> System.out.print(s + " "));
    // .forEach(System.out::print);
    // .forEachOrdered(s -> s.append("_new"));
    // .peek(s -> System.out.print(s + " "))
    // .peek(s -> s.append("_new_1"))

    public static void main(String[] args) {
        // foreach applies the specified method to each element of the stream and finishes working with the stream

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // print collection
        collection.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // convert to upperCase + print
        collection
                .stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // add "_1" and print
        collection
                .stream()
                .map(s -> s + "_1")
                .forEach(System.out::print);
        System.out.println();

        Collection<StringBuilder> stringBuilderCollection = Arrays.asList(new StringBuilder("a1"),
                new StringBuilder("a2"), new StringBuilder("a3"));

        // save the order
        stringBuilderCollection
                .stream()
                .forEachOrdered(s -> s.append("_new"));
        System.out.println("forEachOrdered = " + stringBuilderCollection);

        // peek returns the same stream, but applies the specified method to each element of the stream
        // but it need at the end something like collect()

        // convert to upperCase + print
        List<String> stringList = collection
                .stream()
                .map(String::toUpperCase)
                .peek(s -> System.out.print(s + " "))
                .collect(Collectors.toList());
        System.out.println("stringList = " + stringList);

        // add "_new" to every element
        List<StringBuilder> modifiedCollection = stringBuilderCollection
                .stream()
                .peek(s -> s.append("_new_1"))
                .collect(Collectors.toList());
        System.out.println("modifiedCollection = " + modifiedCollection);
    }
}