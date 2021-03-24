package stream.debugging;

import java.util.stream.IntStream;

import static stream.debugging.Helper.log;

public class ParallelStream {

    public static void main(String[] args) {
        System.out.println("\nParallel stream");
        IntStream parallelStream = IntStream.range(1, 5).parallel();
        debug(parallelStream);
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
    Parallel stream
    20:51:05.490-Invoking terminal method count()
    20:51:05.504-starting-3
    20:51:05.504-starting-1
    20:51:05.504-starting-4
    20:51:05.504-starting-2
    20:51:05.505-filtering-1
    20:51:05.505-filtering-3
    20:51:05.507-filtering-4
    20:51:05.507-filtering-2
    20:51:05.508-post filtering-2
    20:51:05.508-post filtering-4
    20:51:05.509-The count is-2
*/