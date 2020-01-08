package generic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(1);
        Box<Integer> box2 = new Box<>(4);
        Box<String> box3 = new Box<>("string");

        NumberBox<Integer> intBox = new NumberBox<>(new Integer[]{1, 2, 3, 4, 5, 7});
        NumberBox<Double> doubleBox = new NumberBox<>(new Double[]{1., 2., 3., 4., 5., 7.});
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