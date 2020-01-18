package time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiffParseFormat {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        List<LocalDateTime> dateTimeList = new LinkedList<>();
        Collections.addAll(dateTimeList,
                LocalDateTime.parse("2020-01-15T00:00:00"),
                LocalDateTime.parse("2020-01-16T00:00:00"),
                LocalDateTime.parse("2020-01-17T00:00:00"));
        long between = diffMaxMin(dateTimeList);
        System.out.println(between);

        String source = "src/time/dates.txt";
        System.out.println(diffMaxMin(source));

        List<String> stringDates = new LinkedList<>();
        Collections.addAll(stringDates,
                "03 Jun 2018",
                "05 Jul 2018",
                "13 Sep 2018",
                "04 Oct 2018");
        List<String> newStringDates = changeFormat(stringDates);
        newStringDates.forEach(System.out::println);
    }

    private static long diffMaxMin(List<LocalDateTime> dateTimeList) {
        Collections.sort(dateTimeList);
        LocalDateTime min = dateTimeList.get(0);
        LocalDateTime max = dateTimeList.get(dateTimeList.size() - 1);
        return Duration.between(min, max).toDays();
    }

    private static long diffMaxMin(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            List<LocalDate> dates = in
                    .lines()
                    .map(d -> parseDate(d).orElse(LocalDate.now()))
                    .sorted()
                    .collect(Collectors.toList());
            LocalDate min = dates.get(0);
            LocalDate max = dates.get(dates.size() - 1);
            System.out.println(dates);
            return DAYS.between(min, max);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return 0L;
    }

    public static Optional<LocalDate> parseDate(String dateString) {
        try {
            return Optional.of(LocalDate.parse(dateString, formatter));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    private static List<String> changeFormat(List<String> stringDates) {
        // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", new Locale("ru"));
        //formatter.format(TemporalAccessor temporal)
        return stringDates
                .stream()
                .map(d -> LocalDate.parse(d, DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)))
                .sorted()
                .map(formatter::format)
                .collect(Collectors.toList());
    }
}