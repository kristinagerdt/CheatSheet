package stream.methods;

import stream.helper.Person;
import stream.helper.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCountAverage {
    // .filter("a1"::equals)
    // .filter(s -> s.contains("1"))
    // .count()
    // .average().orElse(0.0)
    // .collect(Collectors.summarizingDouble(Person::getAge)).getAverage();
    // .collect(Collectors.averagingInt(i -> i - 1));

    public static void main(String[] args) {
        // filter returns a stream in which there are only elements matching the filter condition
        // count returns the number of elements in the stream
        // average returns the average value
        // collect converts stream to a collection or other data structure
        // Useful static methods from Collectors:
        // toList, toCollection, toSet - represent the stream as a list, collection or set
        // averagingInt, averagingDouble, averagingLong - return the average value

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 6, 4, 4, 7, 5, 1, 4, 5, 2);

        Collection<Person> people = Arrays.asList(
                new Person("Mark", 23, Gender.MAN, true),
                new Person("Alex", 23, Gender.MAN, true),
                new Person("Helen", 42, Gender.WOMAN, true),
                new Person("Stephan", 69, Gender.MAN, false));

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

        // Select Duty Men
        List<Person> dutyMen = people
                .stream()
                .filter(p -> p.getGender() == Gender.MAN && p.getAge() >= 18 && p.getAge() < 27)
                .collect(Collectors.toList());
        System.out.println("dutyMen = " + dutyMen);

        // find the number of potentially working people
        long countOfWorkingPeople = people
                .stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getGender() == Gender.WOMAN && p.getAge() < 55)
                        || (p.getGender() == Gender.MAN && p.getAge() < 60))
                .count();
        System.out.println("countOfWorkingPeople = " + countOfWorkingPeople);

        String sentence = "dhgfj sdhfg ss ght ww vaa vdvd";
        // count the number of words starting with s
        List<String> strings = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        long wordsWithS = strings
                .stream()
                .filter(s -> s.startsWith("s"))
                .count();
        System.out.println("wordsWithS = " + wordsWithS);

        // find the average age among men
        double menAverageAge = people
                .stream()
                .filter(p -> p.getGender() == Gender.MAN)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0); //.getAsDouble()
        System.out.println("manAverageAge = " + menAverageAge);

        // find the average age among all
        double peopleAverageAge = people
                .stream()
                .collect(Collectors.summarizingDouble(Person::getAge))
                .getAverage();
        System.out.println("peopleAverageAge = " + peopleAverageAge);

        // subtract 1 from each element and get the average
        Double average = numbers
                .stream()
                .collect(Collectors.averagingInt(i -> i - 1));
        System.out.println("average = " + average);
    }
}