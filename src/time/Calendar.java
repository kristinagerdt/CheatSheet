package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calendar {
    private static List<Month> months = Arrays.asList(Month.values());
    private static List<String> daysOfWeek = getDaysOfWeek();

    public static void main(String[] args) {
        printYear(2020);
    }

    public static void printYear(int year) {
        months.forEach(month -> printMonth(year, month));
    }

    private static void printMonth(int year, Month month) {
        List<LocalDate> daysOfMonth = getListDaysOfMonth(year, month);
        int indent = startDay(year, month) - 1;

        System.out.println(month + " " + year);
        daysOfWeek.forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        for (int i = 0; i < indent; i++)
            System.out.print("\t");
        for (int i = 1; i <= daysOfMonth.size(); i++) {
            System.out.print(i + "\t");
            if (((i + indent) % 7 == 0) || (i == daysOfMonth.size())) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static List<LocalDate> getListDaysOfMonth(int year, Month month) {
        return IntStream.rangeClosed(1, YearMonth.of(year, month).lengthOfMonth())
                .mapToObj(day -> LocalDate.of(year, month, day))
                .collect(Collectors.toList());
    }

    private static int startDay(int year, Month month) {
        return LocalDate.of(year, month, 1).getDayOfWeek().getValue();
    }

    private static List<String> getDaysOfWeek() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E", Locale.ENGLISH);
        return Arrays
                .stream(DayOfWeek.values())
                .map(formatter::format)
                .collect(Collectors.toList());
    }
}