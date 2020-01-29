package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CounterConsecutiveChars {
    public static void main(String[] args) {
        String input = "aaaabbaacccb";
        //String input = "cccb";
        System.out.println(input);
        System.out.println(counter(input));
        System.out.println(counterStream(input));
    }

    private static String counter(String input) {
        int count = 1;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                output.append(count).append(input.charAt(i));
                count = 1;
            }
        }
        output.append(count).append(input.charAt(input.length() - 1));
        return output.toString();
    }

    private static String counterStream(String input) {
        List<Character> characters = input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Set<Character> uniqueChars = new HashSet<>(characters);
        StringBuilder output = new StringBuilder();
        for (Character c : uniqueChars) {
            long count = characters
                    .stream()
                    .filter(c::equals)
                    .count();
            output.append(count).append(c);
        }
        return output.toString();
    }
}