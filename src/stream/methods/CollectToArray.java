package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectToArray {
    // .collect(Collectors.joining(":", "<b>", "</b>"));
    // .collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1, 2)));
    // .collect(Collectors.toMap(names::indexOf, i -> i)).forEach((k, v) -> System.out.println(k + " " + v));
    // .toArray(String[]::new);
    // custom collector

    public static void main(String[] args) {
        // collect converts stream to a collection or other data structure
        // Useful static methods from Collectors:
        // toList, toCollection, toSet - represent the stream as a list, collection or set
        // toConcurrentMap, toMap - allow you to convert a stream to map using the specified functions
        // mapping - additional value conversions for complex Collectors

        // *** strings
        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

        // combine all elements in one line through the separator : and wrap with <b> ... </b> tags
        String joining = strings
                .stream()
                .collect(Collectors.joining(":", "<b>", "</b>"));
        System.out.println("joining = " + joining);

        // convert to map, where the first character is the key, the second character is the value
        Map<String, String> toMap = strings
                .stream()
                .distinct()
                .collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1, 2)));
        System.out.println("toMap = " + toMap);

        // *** list
        List<String> names = Arrays.asList("peter", "anna", "mike");

        // create a map, key = index, value = name
        names
                .stream()
                .collect(Collectors.toMap(names::indexOf, i -> i))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // get an array of unique values from the string collection
        String[] array = strings
                .stream()
                .distinct()
                .toArray(String[]::new);
        System.out.println("array = " + Arrays.asList(array));

        //custom Collector
        Collector<String, StringBuilder, String> stringBuilderCollector = Collector.of(
                StringBuilder::new, // initialization
                (b, s) -> b.append(s).append(" , "), // processing method for each item
                (b1, b2) -> b1.append(b2).append(" , "), // method of connecting in parallel execution
                StringBuilder::toString // at the end
        );
        String joinBuilder = strings
                .stream()
                .collect(stringBuilderCollector);
        System.out.println("joinBuilder = " + joinBuilder);

        // style JDK7
        StringBuilder b = new StringBuilder(); // initialization
        for (String s : strings) {
            b.append(s).append(" , "); // processing method for each item
        }
        String joinBuilderOld = b.toString(); // at the end
        System.out.println("joinBuilderOld = " + joinBuilderOld);
    }
}