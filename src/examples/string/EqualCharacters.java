package examples.string;

import java.util.Set;
import java.util.stream.Collectors;

public class EqualCharacters {
    public static void main(String[] args) {
        System.out.println(isEqualCharacters("qqq3qqws1a", "31swaq")); // true
        System.out.println(isEqualCharacters("qqqq5qwsa", "swaqr")); // false
        System.out.println(isEqualCharacters("ab", "cg")); // false
    }

    private static boolean isEqualCharacters(String first, String second) {
        Set<Character> firstSet = getCharacterSet(first);
        Set<Character> secondSet = getCharacterSet(second);
        return firstSet.equals(secondSet);
    }

    private static Set<Character> getCharacterSet(String string) {
        return string
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }
}