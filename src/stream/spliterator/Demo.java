package stream.spliterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Collection;

// Differences between Iterator and Spliterator

// ITERATOR
// Since Java 1.2
// Can be used to iterate all collection classes
// Does not support parallel processing

// SPLITERATOR
// Since Java 8
// Can be used to iterate array, stream, list and set. Not possible with map
// Supports parallel processing

public class Demo {
    public static void main(String[] args) {
        size();
        getComparator();
        trySplit();
        tryAdvanced();
        characteristics();
    }

    private static void size() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Spliterator<String> spliterator = list.spliterator();
        System.out.println(spliterator.estimateSize());
        System.out.println(spliterator.getExactSizeIfKnown());
    }

    private static void getComparator() {
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        set.add("A");
        set.add("D");
        set.add("C");
        set.add("B");
        System.out.println(set);
        System.out.println(set.spliterator().getComparator());
    }

    private static void trySplit() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("----------");
        spliterator2.forEachRemaining(System.out::println);
    }

    private static void tryAdvanced() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, -7, 0, -8));
        Spliterator<Integer> spliterator = list1.spliterator();
        while (spliterator.tryAdvance(i -> System.out.print(i + " "))) ;

        List<Integer> list2 = new ArrayList<>();
        spliterator = list1.spliterator();
        while (spliterator.tryAdvance(i -> list2.add(Math.abs(i)))) ;

        spliterator = list2.spliterator();
        System.out.println("\nAbsolute values of contents of list:");
        while (spliterator.tryAdvance(i -> System.out.print(i + " "))) ;
    }

    private static void characteristics() {
        Collection<String> collection = Arrays.asList("as", "vf", "vfg", "ab", "bf", "cad");
        Spliterator<String> spliterator = collection.spliterator();

        int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        System.out.println(spliterator.characteristics() == expected);

        if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }

        if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("DISTINCT");
        }

        if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("SORTED");
        }

        if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }

        if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("CONCURRENT");
        }

        if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("IMMUTABLE");
        }

        if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("NONNULL");
        }

        if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("SUBSIZED");
        }
    }
}