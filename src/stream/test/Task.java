package stream.test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return null;
    }

    public static List<String> getFirstNames(List<String> names) {
        return null;
    }

    public static List<String> getDistinctLetters(List<String> names) {
        return null;
    }

    public static String separateNamesByComma(List<User> users) {
        return null;
    }

    public static Integer getMinAge(List<User> users) {
        return null;
    }

    public static Integer getMaxAge(List<User> users) {
        return null;
    }

    public static double getAverageAge(List<User> users) {
        return 0.0;
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        return null;
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        return null;
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return null;
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        return null;
    }

    public static boolean anyMatch(List<User> users, int age) {
        return false;
    }

    public static boolean noneMatch(List<User> users, int age) {
        return false;
    }

    public static Optional<User> findAny(List<User> users, String name) {
        return null;
    }

    public static List<User> sortByAge(List<User> users) {
        return null;
    }

    public static User findOldest(List<User> users) {
        return null;
    }

    public static int sumAge(List<User> users) {
        return 0;
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return null;
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return null;
    }

    public static List<Integer> generate10RandomNumbers() {
        return null;
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        return null;
    }
}