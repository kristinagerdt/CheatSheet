package stream.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Account a1 = new Account("AABBCC111", Currency.USD);
        Account a2 = new Account("FFGGHH222", Currency.USD);
        Account a3 = new Account("LLMMNN333", Currency.EUR);
        Account a4 = new Account("QQRRSS444", Currency.EUR);
        Account a5 = new Account("WWXXZZ555", Currency.EUR);
        Account a6 = new Account("HJYTFD666", Currency.USD);
        List<Account> accounts = new ArrayList<>();
        Collections.addAll(accounts, a1, a2, a3, a4, a5, a6);

        Person p1 = new Person("Alex", 45, new Address("Baker", 3));
        p1.addAccount(a1);
        p1.addAccount(a2);
        Person p2 = new Person("Maria", 14, new Address("Oxford", 14));
        p2.addAccount(a3);
        Person p3 = new Person("Stephan", 34, new Address("Carnaby", 1));
        p3.addAccount(a4);
        Person p4 = new Person("Max", 24, new Address("Downing", 5));
        p4.addAccount(a5);
        p4.addAccount(a6);
        Person p5 = new Person("Max", 34, new Address("Oxford", 12));
        Person p6 = new Person("Tom", 45, new Address("Bond", 44));
        List<Person> people = new ArrayList<>();
        Collections.addAll(people, p1, p2, p3, p4, p5, p6);

        System.out.println(getAddressesPeopleOlder17(people));
        System.out.println(getDistinctNames(people));
        System.out.println(groupingPeopleByAge(people));
        System.out.println(groupingPeopleByName(people));
        System.out.println(getIbans(accounts));
        System.out.println(getIbansFromPeople(people));
        System.out.println(getSumAgePeopleOlder17(people));
        System.out.println(getPeopleOlder17(people));
    }

    public static List<Address> getAddressesPeopleOlder17(List<Person> people) {
        return people
                .stream()
                .filter(person -> person.getAge() > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());
    }

    public static List<String> getDistinctNames(List<Person> people) {
        return people
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<Person>> groupingPeopleByAge(List<Person> people) {
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }

    public static Map<String, List<Person>> groupingPeopleByName(List<Person> people) {
        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getName, TreeMap::new, Collectors.toList()));
        //.collect(Collectors.groupingBy(Person::getName));
    }

    public static List<String> getIbans(List<Account> accounts) {
        return accounts
                .stream()
                .map(Account::getIban)
                .map(Main::getHiddenIban)
                .collect(Collectors.toList());
    }

    public static List<String> getIbansFromPeople(List<Person> people) {
        return people
                .stream()
                .flatMap(person -> person.getAccounts().stream())
                .map(Account::getIban)
                .map(Main::getHiddenIban)
                .collect(Collectors.toList());
    }

    public static Integer getSumAgePeopleOlder17(List<Person> people) {
        return people
                .stream()
                .map(Person::getAge)
                .filter(p -> p > 17)
                .reduce(0, Integer::sum);
    }

    public static String getPeopleOlder17(List<Person> people) {
        return people
                .stream()
                .filter(person -> person.getAge() > 17)
                .map(Person::getName)
                .collect(Collectors.joining(", ", "In Germany ", " are of legal age."));
    }

    private static String getHiddenIban(String iban) {
        return iban.substring(0, 3) + iban.substring(3).replaceAll("\\w", "*");
    }
}