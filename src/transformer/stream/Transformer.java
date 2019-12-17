package transformer.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transformer {
    public static void main(String[] args) {
        String[] input = {"aaBc", "dEF", "eklm", "nop"};
        List<String> transform = transform(Arrays.asList(input));
        System.out.println(transform(transform));

        String string = "abCd aad BBEF bef aBB Fg";
        System.out.println(string);

        Predicate<String> isTree = s -> s.length() == 3;
        Function<String, String> toLowerCase = String::toLowerCase;
        System.out.println(transform(string, isTree, toLowerCase));

        Predicate<String> isFour = s -> s.length() == 4;
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(transform(string, isFour, toUpperCase));
    }

    private static List<String> transform(List<String> input) {
        return input
                .stream()
                .filter(s -> s.length() == 3)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    private static List<String> transform(String input, Predicate<String> predicate, Function<String, String> function) {
        return Stream.of(input.split(" "))
                .map(s -> predicate.test(s) ? function.apply(s) : s)
                .collect(Collectors.toList());
    }
}