package stream.methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Convert {
    // .map(Double::intValue)

    public static void main(String[] args) {
        // convert to Integer from Double using Double.intValue()
        List<Integer> numbers = asList(1, 4, 16, 256);
        List<Integer> doubleToInt = numbers
                .stream()
                .map(Math::sqrt)
                .map(Double::intValue)
                .collect(Collectors.toList());
        System.out.println("doubleToInt = " + doubleToInt);

        // convert to List<String> from String
        List<String> stringList = "input"
                .chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("stringList = " + stringList);

        // convert to List<Character> from String
        List<Character> characterList = "input"
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("characterList = " + characterList);

        // convert to List<Integer> from array int
        int[] numbersArray = new int[]{2, 3, 5, 1, 3};
        List<Integer> integerList = Arrays
                .stream(numbersArray)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("integerList = " + integerList);
    }
}