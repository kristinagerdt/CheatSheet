package generic.box;

//T, R - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Number and << (Integer, Double, Float)
// super - <T super Integer> T: Integer and >> (Number, Object)

import java.util.ArrayList;

public class NumberBoxGeneric<N extends Number> {
    private N[] numbers;

    public NumberBoxGeneric(N[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;
        for (N item : numbers) {
            sum += item.doubleValue();
        }
        return Math.round(sum / numbers.length * 100.00) / 100.00;
    }

    // NumberBox<N>, compare Integer-Integer, Double-Double, Float-Float
    // NumberBox<?>, compare Integer-Double, Double-Float, Integer-Integer
    public boolean compare(NumberBoxGeneric<?> anotherBox) {
        return Math.abs(average() - anotherBox.average()) < 0.001f;
    }

    public static void main(String[] args) {
        NumberBoxGeneric<Integer> intBox = new NumberBoxGeneric<>(new Integer[]{1, 2, 3, 4, 5, 7});
        NumberBoxGeneric<Double> doubleBox = new NumberBoxGeneric<>(new Double[]{1., 2., 3., 4., 5., 7.});
        System.out.println(intBox.average());
        System.out.println(doubleBox.average());

        System.out.println(intBox.compare(doubleBox));

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();

        copyElements(integers, numbers);
        copyElements(integers, integers);
        copyElements(doubles, numbers);
        //copyElements(numbers,integers);
    }

    //private static <child> void copyElements(ArrayList<child or less> src, ArrayList<child or parent> dist)
    private static <T> void copyElements(ArrayList<? extends T> src, ArrayList<? super T> dist) {
        dist.addAll(src);
    }
}