package time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiffFormat {
    public static void main(String[] args) {
        List<LocalDateTime> dateTimeList = new LinkedList<>();
        Collections.addAll(dateTimeList,
                LocalDateTime.parse("2020-01-15T00:00:00"),
                LocalDateTime.parse("2020-01-16T00:00:00"),
                LocalDateTime.parse("2020-01-17T00:00:00"));
        long between = diffMaxMin(dateTimeList);
        System.out.println(between);

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
        //long between = DAYS.between(min, max);
        return Duration.between(min, max).toDays();
    }

    public static List<String> changeFormat(List<String> stringDates) {
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