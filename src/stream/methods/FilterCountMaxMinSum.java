package stream.methods;

import stream.helper.Person;
import stream.helper.Sex;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCountMaxMinSum {
    // .filter("a1"::equals)
    // .filter(s -> s.contains("1"))
    // .count()
    // .average()
    // .max(Comparator.comparing(Person::getAge)).get()
    // .min(Comparator.comparing(Person::getAge)).get()
    // .sum();

    public static void main(String[] args) {
        // filter returns a stream in which there are only elements matching the filter condition
        // count returns the number of elements in the stream
        // collect converts stream to a collection or other data structure
        // max returns the maximum element, using a comparator as a condition
        // min returns the minimum element, using a comparator as a condition

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // count the number of repetitions of the selected item
        long countA1 = collection
                .stream()
                .filter("a1"::equals)
                .count();
        System.out.println("countA1 = " + countA1);

        // select all elements by template
        List<String> collectionWith1 = collection
                .stream()
                .filter(s -> s.contains("1"))
                .collect(Collectors.toList());
        System.out.println("collectionWith1 = " + collectionWith1);

        // work with the objects
        Collection<Person> people = Arrays.asList(
                new Person("Mark", 16, Sex.MAN),
                new Person("Alex", 23, Sex.MAN),
                new Person("Helen", 42, Sex.WOMAN),
                new Person("Stephan", 69, Sex.MAN));

        // Select Duty Men
        List<Person> dutyMen = people
                .stream()
                .filter(p -> p.getSex() == Sex.MAN && p.getAge() >= 18 && p.getAge() < 27)
                .collect(Collectors.toList());
        System.out.println("dutyMen = " + dutyMen);

        // find the average age among men
        double menAverageAge = people
                .stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0); //.getAsDouble()
        System.out.println("manAverageAge = " + menAverageAge);

        // find the oldest person
        Person oldestPerson = people
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("oldestPerson " + oldestPerson);

        // find the youngest person
        Person youngestPerson = people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("youngestPerson " + youngestPerson);

        // get the sum of the odd numbers using sum()
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sumOdd = numbers
                .stream()
                .mapToInt(i -> i % 2 != 0 ? i : 0)
                .sum();
        System.out.println("sumOdd=" + sumOdd);

        // find the number of potentially working people
        long countOfWorkingPeople = people
                .stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Sex.WOMAN && p.getAge() < 55) || (p.getSex() == Sex.MAN && p.getAge() < 60))
                .count();
        System.out.println("countOfWorkingPeople = " + countOfWorkingPeople);
    }
}