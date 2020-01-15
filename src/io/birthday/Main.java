package io.birthday;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        sortByBirthday("src/io/birthday/birthdayIn.txt");
        sortByBirthdayWithCheckDate("src/io/birthday/birthdayIn.txt");
        findInvalidFormat("src/io/birthday/birthdayIFIn.txt");
    }

    private static void sortByBirthday(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter("src/io/birthday/birthdayOut.txt")) {
            List<String> result = in
                    .lines()
                    .map(s -> s.split(","))
                    .sorted(Comparator.comparing(d -> LocalDate.parse(d[1], formatter)))
                    .map(p -> p[0] + " " + p[1])
                    .collect(Collectors.toList());
            result.forEach(out::println);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortByBirthdayWithCheckDate(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter("src/io/birthday/birthdayOut.txt")) {
            List<String> result = in
                    .lines()
                    .map(s -> s.split(","))
                    .sorted(Comparator.comparing(a -> checkDate(a[1]).orElse(new Date())))
                    .map(p -> p[0] + " " + p[1])
                    .collect(Collectors.toList());
            result.forEach(out::println);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<Date> checkDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            return Optional.of(dateFormat.parse(date));
        } catch (ParseException e) {
            return Optional.empty();
        }
    }

    private static void findInvalidFormat(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter("src/io/birthday/birthdayIFOut.txt")) {
            List<String> result = in
                    .lines()
                    .map(s -> s.split(","))
                    .filter(s -> !s[1].matches("\\d{2}-\\d{2}-\\d{4}"))
                    .map(p -> p[0] + " " + p[1])
                    .collect(Collectors.toList());
            result.forEach(out::println);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}