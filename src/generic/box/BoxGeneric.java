package generic.box;

//T, R - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Number and << (Integer, Double, Float)
// super - <T super Integer> T: Integer and >> (Number, Object)

import java.util.ArrayList;
import java.util.List;

public class BoxGeneric<T> {
    private T value;

    public BoxGeneric() {
    }

    public BoxGeneric(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{value=" + value + '}';
    }

    public static void main(String[] args) {
        BoxGeneric<Integer> box1 = new BoxGeneric<>(1);
        BoxGeneric<Double> box2 = new BoxGeneric<>(4.);
        BoxGeneric<String> box3 = new BoxGeneric<>("String");

        List<BoxGeneric<? extends Object>> objects = new ArrayList<>();

        BoxGeneric<String> printerString = new BoxGeneric<>();
        printerString.setValue("Hello!");
        String valueString = printerString.getValue();
        objects.add(printerString);

        BoxGeneric<Integer> printerInteger = new BoxGeneric<>();
        printerInteger.setValue(10);
        Integer valueInteger = printerInteger.getValue();
        objects.add(printerInteger);

        BoxGeneric<Double> printerDouble = new BoxGeneric<>();
        printerDouble.setValue(10.);
        Double valueDouble = printerDouble.getValue();
        objects.add(printerDouble);

        BoxGeneric<Letter> printerLetter = new BoxGeneric<>();
        printerLetter.setValue(new Letter("Hello!"));
        Letter valueLetter = printerLetter.getValue();
        objects.add(printerLetter);

        System.out.println(objects);
    }
}