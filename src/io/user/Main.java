package io.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String source = "src/io/user/users.csv"; // ".\\files\\users.csv"

        List<User> sortedUsers = sortByAge(source);
        System.out.println(sortedUsers);

        List<User> sortedUsersOlder17 = sortUsersOlder17(source);
        System.out.println(sortedUsersOlder17);

        List<User> users = Arrays.asList(
                new User("Alex", 80),
                new User("Max", 23),
                new User("Anna", 40)
        );
        saveSortedUsersToFile(users, "src/io/user/usersFromList.csv");
    }

    private static void saveSortedUsersToFile(List<User> users, String destination) {
        try (PrintWriter out = new PrintWriter(destination)) {
            users
                    .stream()
                    .sorted(Comparator.comparing(User::getAge))
                    .map(Main::userToString)
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> sortUsersOlder17(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            return in
                    .lines()
                    .map(Main::userFromString)
                    .filter(u -> u.getAge() > 17)
                    .sorted(Comparator.comparing(User::getAge))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            return new LinkedList<>();
        }
    }

    private static List<User> sortByAge(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            return in
                    .lines()
                    .map(Main::userFromString)
                    .sorted(Comparator.comparing(User::getAge))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            return new LinkedList<>();
        }
    }

    private static User userFromString(String input) {
        String[] array = input.split(";");
        return new User(array[0], Integer.parseInt(array[1]));
    }

    public static String userToString(User user) {
        return user.getName() + ";" + user.getAge();
    }
}