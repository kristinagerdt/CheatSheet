package stream.test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

public class Task {
    public static List<String> mapToUpperCase(List<String> strings) {
        return strings
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Math::sqrt)
                .map(Double::intValue)
                .collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user) {
        return user
                .stream()
                .map(User::getAge)
                .collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        long count = users
                .stream()
                .filter(user -> user.getAge() > 25)
                .count();
        return Math.toIntExact(count);
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        return users
                .stream()
                .map(User::getAge)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers) {
        return integers
                .stream()
                .reduce(0, Integer::sum);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers
                .stream()
                .skip(toSkip)
                .collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        return names
                .stream()
                .map(s -> s.split(" "))
                .map(s -> s[0])
                .collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names) {
        return names
                .stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
    }

    public static String separateNamesByComma(List<User> users) {
        return users
                .stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
    }

    public static Integer getMinAge(List<User> users) {
        return users
                .stream()
                .map(User::getAge)
                .reduce(Integer::min)
                .orElse(0);
    }

    public static Integer getMaxAge(List<User> users) {
        return users
                .stream()
                .map(User::getAge)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double getAverageAge(List<User> users) {
        return users
                .stream()
                .map(User::getAge)
                .collect(Collectors.summarizingDouble(u -> u))
                .getAverage();
    }

    public static Map<Boolean, List<User>> partitionUsersByGender(List<User> users) {
        return users
                .stream()
                .collect(Collectors.partitioningBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age) {
        return users
                .stream()
                .anyMatch(user -> user.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age) {
        return users
                .stream()
                .noneMatch(user -> user.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name) {
        return users
                .stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    public static List<User> sortByAge(List<User> users) {
        return users
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public static User findOldest(List<User> users) {
        return users
                .stream()
                .max(Comparator.comparing(User::getAge))
                .orElse(new User("Nobody", 1000));
    }

    public static int sumAge(List<User> users) {
        return users
                .stream()
                .mapToInt(User::getAge)
                .sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return users
                .stream()
                .collect(Collectors.summarizingInt(User::getAge));
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return stream
                .boxed();
    }

    public static List<Integer> generate10RandomNumbers() {
        return new Random()
                .ints()
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        return IntStream
                .range(2, 100)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(d -> n % d != 0))
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
    }
}