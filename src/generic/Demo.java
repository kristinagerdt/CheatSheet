package generic;

//T, R - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Number and << (Integer, Double, Float)
// super - <T super Integer> T: Integer and >> (Number, Object)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(10L);
        numberList.add(2.4);
        System.out.println(numberList);

        // extends Number -> Number and << (Integer, Double, Float)
        List<? extends Number> numbers = new ArrayList<Integer>();

        // super Integer -> Integer and >> (Number, Object)
        List<? super Integer> integers = new ArrayList<Number>();

        List<Double> doubleList = Arrays.asList(3.1, 4.2, 7.5, 14.0);
        List<Integer> integerList = Arrays.asList(3, 4, 7, 14);
        System.out.println("Sum of doubleList = " + sumOfList(doubleList));
        System.out.println("Sum of integerList = " + sumOfList(integerList));

        Integer[] intArray = {3, 5, 8, 0, 10, 11};
        Integer intNum = 5;
        System.out.println("Count of numbers greater than " + intNum + " is " + countGreaterThan(intArray, intNum));

        Double[] doubleArray = {3.1, 5.4, 8.7, 0.2, 10.4, 11.3};
        Double doubleNum = 5.2;
        System.out.println("Count of numbers greater than " + doubleNum + " is " + countGreaterThan(doubleArray, doubleNum));
    }

    public static double sumOfList(List<? extends Number> values) {
        double sum = 0;
        for (Number num : values) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static <T extends Comparable<T>> long countGreaterThan(T[] array, T num) {
        return Arrays
                .stream(array)
                .filter(p -> p.compareTo(num) > 0)
                .count();
    }
}