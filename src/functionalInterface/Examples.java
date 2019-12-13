package functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Examples {
    public static void main(String[] args) {
        //input - 1 String, output - 2 String
        Function<String, String> function = s -> s.toUpperCase(); //String::toUpperCase;
        System.out.println(function.apply("hello!"));

        //input - String, output - boolean ALWAYS
        Predicate<String> predicate = s -> s.length() == 3;
        System.out.println(predicate.test("Hello!"));

        //Поставщик. input - void/null, output - String
        Supplier<String> supplier = () -> "Hello this cruel world!";
        System.out.println(supplier.get());

        //Потребитель. input - String, output - void
        Consumer<String> consumer = s -> System.out.println("+++ " + s + " +++");
        consumer.accept("Hello!");
        print(consumer, "Hello!");
        print(s -> System.out.println("*** " + s + " ***"), "Hello!");
    }

    private static void print(Consumer<String> printer, String input) {
        printer.accept(input);
    }
}