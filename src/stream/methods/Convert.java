package stream.methods;

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

    }
}