package time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZones {
    public static void main(String[] args) {
        String timeZone1 = "Europe/Berlin";
        String timeZone2 = "Asia/Yekaterinburg";

        long diff = getDifferenceTimeZones(timeZone1, timeZone2);
        System.out.println("Difference between \'" + timeZone1 + "\' and \'" + timeZone2 + "\' is " + diff + " hours");
    }

    private static long getDifferenceTimeZones(String timeZone1, String timeZone2) {
        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime zonedDateTime1 = now.atZone(ZoneId.of(timeZone1));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(now, ZoneId.of(timeZone2));

        return Duration.between(zonedDateTime1, zonedDateTime2).toHours();
    }
}