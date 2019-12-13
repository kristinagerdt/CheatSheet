package functionalInterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class Transformer {
    public static void main(String[] args) {
        String str = "abCd aad BBEF bef abb Fg";
        System.out.println(str);

        Predicate<String> isThree = s -> s.length() == 3;
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(transform(str, isThree, toUpperCase));

        Predicate<String> isFour = s -> s.length() == 4;
        Function<String, String> toLowerCase = s -> s.toLowerCase();
        System.out.println(transform(str, isFour, toLowerCase));
    }

    private static String transform(String input, Predicate<String> predicate, Function<String, String> function) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (predicate.test(words[i])) {
                words[i] = function.apply(words[i]);
            }
        }
        return String.join(" ", words);
    }
}