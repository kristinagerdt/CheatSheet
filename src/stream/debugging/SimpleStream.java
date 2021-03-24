package stream.debugging;

import java.util.stream.IntStream;

import static stream.debugging.Helper.log;

public class SimpleStream {

    public static void main(String[] args) {
        System.out.println("Simple stream");
        IntStream stream = IntStream.range(1, 5);
        debug(stream);
    }

    private static void debug(IntStream stream) {
        stream = stream
                .peek(i -> log("starting", i))
                .filter(i -> {
                    log("filtering", i);
                    return i % 2 == 0;
                })
                .peek(i -> log("post filtering", i));
        log("Invoking terminal method count()");
        log("The count is", stream.count());
    }
}

/*
    Simple stream
    20:52:59.923-Invoking terminal method count()
    20:52:59.949-starting-1
    20:52:59.952-filtering-1
    20:52:59.954-starting-2
    20:52:59.955-filtering-2
    20:52:59.957-post filtering-2
    20:52:59.958-starting-3
    20:52:59.960-filtering-3
    20:52:59.962-starting-4
    20:52:59.963-filtering-4
    20:52:59.964-post filtering-4
    20:52:59.966-The count is-2
*/