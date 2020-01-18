package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        // java.util.time.*
        // 1 LocalDate
        // 2 LocalTime
        // 3 LocalDateTime 1+2
        // 4 TimeZone
        // ZonedDateTime 3+4

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.plusDays(2));
        System.out.println(localDate.minusDays(12));

        LocalDate parsedDate = LocalDate.parse("2020-01-17");
        System.out.println("parsedDate: " + parsedDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = formatter.format(parsedDate);
        System.out.println("formattedDate: " + formattedDate);

        LocalDate formatterParsedDate = LocalDate.parse("17-01-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        //LocalDate formatterParsedDate = LocalDate.parse("17-01-2020", formatter);
        System.out.println("formatterParsedDate: " + formatterParsedDate);

        DayOfWeek dayOfWeek = LocalDate.parse("2020-01-17").getDayOfWeek();
        System.out.println("dayOfWeek " + dayOfWeek);

        Month month = LocalDate.parse("2020-01-17").getMonth();
        System.out.println("month " + month);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        //availableZoneIds.forEach(System.out::println);

        Iterator<String> iterator = availableZoneIds.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Monaco");

        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, zoneId);
        System.out.println(zonedDateTime);
    }
}