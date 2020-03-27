package functionalInterface.comparator.person_classic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alex", "Smith", 32, 181.5);
        Person p2 = new Person("Max", "Brown", 13, 154);
        Person p3 = new Person("Helen", "Black", 24, 167);
        Person p4 = new Person("Ann", "Smith", 46, 171.2);
        Person[] people = {p1, p2, p3, p4};

        System.out.println("Before:");
        print(people);

        Arrays.sort(people, new FirstNameComparator());
        System.out.println("\nAfter sort by FirstName:");
        print(people);

        Arrays.sort(people, new LastNameComparator());
        System.out.println("\nAfter sort by LastName:");
        print(people);

        Arrays.sort(people, new AgeComparator());
        System.out.println("\nAfter sort by Age:");
        print(people);

        Arrays.sort(people, new HeightComparator());
        System.out.println("\nAfter sort by Height:");
        print(people);
    }

    private static void print(Person[] people) {
        Arrays
                .stream(people)
                .forEach(System.out::println);
    }
}