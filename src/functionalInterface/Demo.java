package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class Demo {
    public static void main(String[] args) {
        runnable();
        supplier();
        consumer();
        biConsumer();
        doubleConsumer();
        function();
        biFunction();
        doubleFunction();
        unaryOperator();
        binaryOperator();
        predicate();
        biPredicate();
    }

    private static void runnable() {
        // Runnable, input - none, output - void, run()
        Runnable runnable = () -> System.out.println("Runnable");
        repeat(2, runnable);
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) action.run();
    }

    private static void supplier() {
        // Supplier<T>, input - none, output - T, get()
        Supplier<String> stringSupplier = () -> "Hello this cruel world!";
        System.out.println("Supplier<String>: " + stringSupplier.get());

        Supplier<Integer> integerSupplier = () -> 247;
        System.out.println("Supplier<Integer>: " + integerSupplier.get());
    }

    private static void consumer() {
        // Consumer<T>, input - T, output - void, accept()
        Consumer<String> stringConsumer = s -> System.out.println("Consumer<String>: " + s);
        stringConsumer.accept("Hello!");
        print(stringConsumer, "Hello!");
        print(s -> System.out.println("*** " + s + " ***"), "Hello!");

        Consumer<Double> doubleConsumer = d -> System.out.println("Consumer<Double>: " + Math.sqrt(d));
        doubleConsumer.accept(16.0);
    }

    private static void print(Consumer<String> consumer, String input) {
        consumer.accept(input);
    }

    private static void biConsumer() {
        // BiConsumer<T, U>, input - T,U, output - void, accept()
        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + ": " + i * 10);
        biConsumer.accept("BiConsumer<String, Integer>", 5);
    }

    private static void doubleConsumer() {
        // PConsumer, input p, output - void, accept()
        // DoubleConsumer, input - double, output - void, accept()
        DoubleConsumer display = d -> System.out.println("DoubleConsumer: " + d * 10);
        DoubleConsumer division = d -> d /= 2;
        DoubleConsumer composite = division.andThen(display);
        composite.accept(3);
    }

    private static void function() {
        // Function<T, R>, input - T, output - R, apply()
        Function<String, String> function = s -> s.toUpperCase(); //String::toUpperCase;
        System.out.println(function.apply("Function<String, String>"));
    }

    private static void biFunction() {
        // BiFunction<T, U, R>, input T,U, output - R, apply()
        BiFunction<Integer, Integer, String> biFunction = (i1, i2) -> "BiFunction<Integer, Integer, String>: " + (i1 * i2);
        System.out.println(biFunction.apply(5, 2));
    }

    private static void doubleFunction() {
        // PFunction<T>, input - p, output - T, apply()
        // DoubleFunction<String>, input - Double, output - String, apply()
        DoubleFunction<String> stringDoubleFunction = d -> "DoubleFunction<String>: " + d;
        System.out.println(stringDoubleFunction.apply(45.8));
    }

    private static void unaryOperator() {
        // UnaryOperator<T>, input - T, output - T, apply()
        UnaryOperator<Integer> unaryOperator = i -> ++i;
        System.out.println(unaryOperator.apply(7));
    }

    private static void binaryOperator() {
        // BinaryOperator<T>, input - T,T, output - T, apply
        BinaryOperator<Double> binaryOperator = (d1, d2) -> d1 * d2;
        System.out.println(binaryOperator.apply(7.2, 4.5));
    }

    private static void predicate() {
        // Predicate<T>, input - T, output - boolean ALWAYS
        Predicate<String> predicate = s -> s.length() == 3;
        System.out.println(predicate.test("Predicate<String>"));
    }

    private static void biPredicate() {
        // BiPredicate<T, U>, input - T,U, output - boolean ALWAYS
        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() == i;
        System.out.println(biPredicate.test("BiPredicate<String, Integer>", 28));
    }
}