package stream.methods;

import stream.entity.Person;
import stream.entity.Gender;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByPartitionBy {
    // .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
    // .collect(Collectors.groupingBy(s -> s.substring(0, 1),
    //                                Collectors.mapping(s -> s.substring(1, 2),
    //                                                   Collectors.joining(":"))));
    // .collect(Collectors.groupingBy(Person::getGender));
    // .collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(Person::getAge)));
    // .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

    // .collect(Collectors.partitioningBy(Person::isAlive));
    // .collect(Collectors.partitioningBy(i -> i % 2 == 0));
    // .collect(Collectors.partitioningBy((p) -> p % 2 == 0));

    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Collection<Person> people = Arrays.asList(
                new Person("Mark", 23, Gender.MAN, true),
                new Person("Alex", 23, Gender.MAN, true),
                new Person("Helen", 42, Gender.WOMAN, true),
                new Person("Stephan", 69, Gender.MAN, false));

        // convert to map, grouping by the first character of the examples.string
        Map<String, List<String>> groupingBy = strings
                .stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println("groupingBy = " + groupingBy);

        // convert to map, grouping by the first character of the examples.string
        // and take the second character as the value, combine through :
        Map<String, String> groupingByJoining = strings
                .stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1),
                        Collectors.mapping(s -> s.substring(1, 2),
                                Collectors.joining(":"))));
        System.out.println("groupingByJoining = " + groupingByJoining);

        // group people by Gender
        Map<Gender, List<Person>> groupingByGender = people
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println("groupingByGender");
        groupingByGender.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));

        // group people by Gender and then by Age
        Map<Gender, Map<Integer, List<Person>>> groupingByGenderThenByAge = people
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(Person::getAge)));
        System.out.println("groupingByGenderThenByAge");
        groupingByGenderThenByAge.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));

        // group people by Gender and count value
        Map<Gender, Long> groupingByGenderAndCount = people
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println("groupingByGenderAndCount");
        groupingByGenderAndCount.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));

        // partition people by Gender. It works ONLY with Predicate
        Map<Boolean, List<Person>> partitionByAlive = people
                .stream()
                .collect(Collectors.partitioningBy(Person::isAlive));
        System.out.println("partitionByAlive");
        partitionByAlive.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));

        // divide the numbers into even and odd
        Map<Boolean, List<Integer>> parts = numbers
                .stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("parts = " + parts);

        // make a map, key=true/false, value=even/odd values
        Map<Boolean, List<Integer>> mapOddEven = numbers
                .stream()
                .collect(Collectors.partitioningBy((p) -> p % 2 == 0));
        System.out.println("mapOddEven = " + mapOddEven);
    }
}