package stream.methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectToArray {
    // .collect(Collectors.summingInt(i -> i % 2 != 0 ? i : 0));
    // .collect(Collectors.averagingInt(i -> i - 1));
    // .collect(Collectors.summarizingInt(i -> i + 3));
    // .collect(Collectors.summarizingInt(i -> i % 2 != 0 ? i : 0)).getSum();
    // .collect(Collectors.partitioningBy(i -> i % 2 == 0));
    // .collect(Collectors.partitioningBy((p) -> p % 2 == 0));
    // .collect(Collectors.joining(":", "<b>", "</b>"));
    // .collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1, 2)));
    // .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
    // .collect(Collectors.groupingBy(s -> s.substring(0, 1),
    //                                Collectors.mapping(s -> s.substring(1, 2),
    //                                                   Collectors.joining(":"))));
    // .collect(Collectors.toMap(names::indexOf, i -> i)).forEach((k, v) -> System.out.println(k + " " + v));
    // .toArray(String[]::new);
    // custom collector

    public static void main(String[] args) {
        // collect converts stream to a collection or other data structure
        // Useful static methods from Collectors:
        // toList, toCollection, toSet - represent the stream as a list, collection or set
        // toConcurrentMap, toMap - allow you to convert a stream to map using the specified functions
        // averagingInt, averagingDouble, averagingLong - return the average value
        // summingInt, summingDouble, summingLong - returns the sum
        // summarizingInt, summarizingDouble, summarizingLong - return SummaryStatistics with different aggregate values
        // partitioningBy - splits the collection into two parts according to the condition and returns them as Map <Boolean, List>
        // groupingBy - split the collection by condition and return Map <N, List <T>>, where T is the type of the last stream, N is the value of the separator
        // mapping - additional value conversions for complex Collectors

        // *** numbers
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // get the sum of the odd numbers using Collectors.summingInt()
        Integer sumOddSummingInt = numbers
                .stream()
                .collect(Collectors.summingInt(i -> i % 2 != 0 ? i : 0));
        System.out.println("sumOddSummingInt=" + sumOddSummingInt);

        // subtract 1 from each element and get the average
        Double average = numbers
                .stream()
                .collect(Collectors.averagingInt(i -> i - 1));
        System.out.println("average = " + average);

        // add to numbers 3 and get statistics
        IntSummaryStatistics statistics = numbers
                .stream()
                .collect(Collectors.summarizingInt(i -> i + 3));
        System.out.println("statistics = " + statistics);

        // get the sum of the even numbers through IntSummaryStatistics
        long sumEven = numbers
                .stream()
                .collect(Collectors.summarizingInt(i -> i % 2 != 0 ? i : 0))
                .getSum();
        System.out.println("sumEven = " + sumEven);

        // divide the numbers into even and odd
        Map<Boolean, List<Integer>> parts = numbers
                .stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("parts = " + parts);

        // make a map, key=true/false, value=even/odd values
        Map<Boolean, List<Integer>> mapOddEven = numbers
                .stream()
                .collect(Collectors.partitioningBy((p) -> p % 2 == 0));
        System.out.println("mapOddEven = " + mapOddEven);

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

        // convert to map, grouping by the first character of the string
        Map<String, List<String>> groupingBy = strings
                .stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println("groupingBy = " + groupingBy);

        // convert to map, grouping by the first character of the string
        // and take the second character as the value, combine through :
        Map<String, String> groupingByJoining = strings
                .stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1),
                        Collectors.mapping(s -> s.substring(1, 2),
                                Collectors.joining(":"))));
        System.out.println("groupingByJoining = " + groupingByJoining);

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