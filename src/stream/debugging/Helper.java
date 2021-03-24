package stream.debugging;

import java.time.LocalTime;

public class Helper {
    public static void log(Object... objects) {
        StringBuilder result = new StringBuilder(LocalTime.now().toString());
        for (Object object : objects) {
            result.append('-').append(object.toString());
        }
        System.out.println(result);

        // putting a little delay so that we can see a clear difference with parallel stream
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}