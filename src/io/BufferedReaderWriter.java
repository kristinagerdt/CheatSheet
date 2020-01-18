package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        // FileReader reader = new FileReader("file.txt");
        // BufferedReader in = new BufferedReader(reader);
        // BufferedWriter out = new BufferedWriter(new FileWriter("result.txt")))
        // PrintWriter out = new PrintWriter("src/io/files/sum.txt"))

        System.out.println("Sum=" + getSum());

        Map<String, Long> map = createMap("src/io/files/input.txt");
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static Integer getSum() {
        try (BufferedReader in = new BufferedReader(new FileReader("src/io/files/numbers.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("src/io/files/sum.txt"))) {
            // PrintWriter out = new PrintWriter("src/io/files/sum.txt")) {
            Integer sum = in
                    .lines()
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
            out.write(sum.toString());
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static Map<String, Long> createMap(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            return in
                    .lines()
                    .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}