package stream.methods;

import stream.helper.Gender;
import stream.helper.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Match {
    // .anyMatch(user -> user.getAge() == age);
    // .noneMatch(user -> user.getAge() == age);
    // .filter(user -> user.getName().equals(name)).findAny();

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        Collection<Person> people = Arrays.asList(
                new Person("Mark", 23, Gender.MAN, true),
                new Person("Alex", 23, Gender.MAN, true),
                new Person("Helen", 42, Gender.WOMAN, true),
                new Person("Stephan", 69, Gender.MAN, false));

        int age = 23;
        String name = "Helen";

        // find anybody with age=23
        boolean findAnyWithAge = people
                .stream()
                .anyMatch(user -> user.getAge() == age);
        System.out.println("findAnyWithAge = " + findAnyWithAge);

        // find nobody with age=23
        boolean findNoneWithAge = people
                .stream()
                .noneMatch(user -> user.getAge() == age);
        System.out.println("findNoneWithAge = " + findNoneWithAge);

        // find anybody with name="Helen"
        Optional<Person> findAnyWithName = people
                .stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
        findAnyWithName.ifPresent(person -> System.out.println("findAnyWithName = " + person));

        // find if at least one "a1" item exists in the collection
        boolean result1 = collection
                .stream()
                .anyMatch("a1"::equals);
        System.out.println("Is there at least one 'a1' element? " + result1);

        // find if there is a symbol "1" for all elements of the collection
        boolean result2 = collection
                .stream()
                .allMatch((s) -> s.contains("1"));
        System.out.println("Do all elements have a '1'? " + result2);

        // check that no "a7" items exist in the collection
        boolean result3 = collection
                .stream()
                .noneMatch("a7"::equals);
        System.out.println("not a single 'a7' element exists? " + result3);

        String test = "24";
        // check if string is a number
        boolean isDigit = test
                .chars()
                .allMatch(Character::isDigit);
        System.out.println(test + " is digit? " + isDigit);
    }
}