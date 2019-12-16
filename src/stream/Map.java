package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        Collection<String> stringCollection = Arrays.asList("a1", "a2", "a3", "a4");
        // map
        // Change all items
        List<String> transform = stringCollection
                .stream()
                .map(i -> i + "_1")
                .collect(Collectors.toList());
        System.out.println("transform = " + transform);

        // Delete the first character and return the numbers
        List<Integer> numbersList = stringCollection
                .stream()
                .map(i -> Integer.parseInt(i.substring(1)))
                .collect(Collectors.toList());
        System.out.println("numbersList = " + numbersList);

        // mapToInt
        // Delete the first character and return the numbers
        int[] numbersArray = stringCollection
                .stream()
                .mapToInt(i -> Integer.parseInt(i.substring(1)))
                .toArray();
        System.out.println("numbersArray = " + Arrays.toString(numbersArray));

        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        // flatMap can make another kind of stream
        // Get all numeric values (as String) that are stored separated by commas
        String[] numbers = collection
                .stream()
                .flatMap(i -> Arrays.stream(i.split(",")))
                .toArray(String[]::new);
        System.out.println("numbers as String = " + Arrays.toString(numbers));

        // flatMapToInt
        // Get all numeric values that are stored separated by commas
        int[] trueNumbers = collection
                .stream()
                .flatMapToInt(i -> Arrays.stream(i.split(",")).mapToInt(Integer::parseInt))
                .toArray();
        System.out.println("true numbers from String collection = " + Arrays.toString(trueNumbers));

        // flatMap + mapToInt
        // Get all numeric values that are stored separated by commas
        int[] mixNumbers = collection
                .stream()
                .flatMap(i -> Arrays.stream(i.split(",")))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("true numbers from String collection = " + Arrays.toString(mixNumbers));
    }
}