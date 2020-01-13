package stream.methods;

import stream.entity.Person;
import stream.entity.Gender;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {
    // .sorted()
    // .sorted(Comparator.naturalOrder())
    // .sorted(Comparator.reverseOrder())
    // .sorted((o1, o2) -> -o1.compareTo(o2))
    // .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
    // .sorted(Comparator.comparing(Person::getGender).reversed())
    // .sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge))

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        // sort by alphabet using .sorted()
        List<String> sorted = collection
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted = " + sorted);

        // sort by alphabet using Comparator.naturalOrder()
        List<String> sortedComparator = collection
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("sortedComparator = " + sortedComparator);

        // sort by alphabet + delete replays
        List<String> sortedDistinct = collection
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct);

        // sort in reverse alphabetical order using compareTo()
        List<String> sortedReverse = collection
                .stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse);

        // sort in reverse alphabetical order using Comparator.reverseOrder()
        List<String> sortedReverseComparator = collection
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("sortedReverseComparator = " + sortedReverseComparator);

        // work with the objects
        Collection<Person> people = Arrays.asList(
                new Person("Mark", 23, Gender.MAN, true),
                new Person("Alex", 23, Gender.MAN, true),
                new Person("Helen", 42, Gender.WOMAN, true),
                new Person("Stephan", 69, Gender.MAN, false));

        // sort by name in reverse alphabetical order
        List<Person> sortedByNameReversed = people
                .stream()
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println("sortedByNameReversed = " + sortedByNameReversed);

        // sort by name in reverse alphabetical order using Comparator.comparing()
        Comparator<Person> comparatorByAge = Comparator.comparing(Person::getAge);
        Comparator<Person> comparatorByAgeReversed = comparatorByAge.reversed();

        List<Person> sortedByNameReversedComparator = people
                .stream()
                .sorted(comparatorByAgeReversed)
                .collect(Collectors.toList());
        System.out.println("sortedByNameReversedComparator = " + sortedByNameReversedComparator);

        // sort by name in reverse alphabetical order using Comparator.comparing()
        Comparator<Person> comparatorByGender = Comparator.comparing(Person::getGender);

        List<Person> sortedByGenderReversedComparator = people
                .stream()
                .sorted(comparatorByGender.reversed())
                .collect(Collectors.toList());
        System.out.println("sortedByGenderReversedComparator = " + sortedByGenderReversedComparator);

        // sort by Gender and then by Age
        List<Person> sortedByGenderAndAge = people
                .stream()
                .sorted((o1, o2) -> o1.getGender() != o1.getGender() ? o1.getGender().compareTo(o2.getGender()) : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("sortedByGenderAndAge = " + sortedByGenderAndAge);

        // sort by Sex and then by Age using Comparator.comparing().thenComparing
        Comparator<Person> comparatorByGenderAndAge = Comparator.comparing(Person::getGender).thenComparing(Person::getAge);

        List<Person> sortedByGenderAndAgeComparator = people
                .stream()
                .sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("sortedByGenderAndAgeComparator = " + sortedByGenderAndAgeComparator);
    }
}