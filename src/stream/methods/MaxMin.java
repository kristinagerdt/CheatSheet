package stream.methods;

import stream.entity.Person;
import stream.entity.Gender;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxMin {
    // .max(Integer::compareTo)
    // .min(Integer::compareTo)
    // .max(Comparator.comparing(Person::getAge));
    // .min(Comparator.comparing(Person::getAge));
    // .reduce(0, Integer::max)
    // .reduce(Integer::min);
    // .collect(Collectors.summarizingInt(i -> i)).getMax();
    // .collect(Collectors.summarizingInt(i -> i)).getMin();

    public static void main(String[] args) {
        // max returns the maximum element, using a comparator as a condition
        // min returns the minimum element, using a comparator as a condition

        Integer[] array = {1, 2, 5, 6, 4, 7, 8};
        Collection<Integer> collection = Arrays.asList(array);

        Collection<Person> people = Arrays.asList(
                new Person("Mark", 23, Gender.MAN, true),
                new Person("Alex", 23, Gender.MAN, true),
                new Person("Helen", 42, Gender.WOMAN, true),
                new Person("Stephan", 69, Gender.MAN, false));

        // get the maximum value from collection using .max()
        Integer max = collection
                .stream()
                .max(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
        System.out.println("max = " + max);

        // find the oldest person
        Person oldestPerson = people
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("oldestPerson " + oldestPerson);

        // get the maximum value from collection using .reduce()
        Integer maxReduce = collection
                .stream()
                .reduce(0, Integer::max);
        System.out.println("maxReduce = " + maxReduce);

        // get the maximum value from collection using Collectors
        int maxCollectors = collection
                .stream()
                .collect(Collectors.summarizingInt(i -> i))
                .getMax();
        System.out.println("maxCollectors = " + maxCollectors);

        // get the minimum value from collection using .min()
        Integer min = collection
                .stream()
                .min(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        System.out.println("min = " + min);

        // find the youngest person
        Person youngestPerson = people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("youngestPerson " + youngestPerson);

        // get the minimum value from collection using .reduce()
        Integer minReduce = collection
                .stream()
                .reduce(Integer::min)
                .get();
        System.out.println("minReduce = " + minReduce);

        // get the minimum value from collection using Collectors
        int minCollectors = collection
                .stream()
                .collect(Collectors.summarizingInt(i -> i))
                .getMin();
        System.out.println("minCollectors = " + minCollectors);
    }
}