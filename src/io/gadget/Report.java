package io.gadget;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {
    public static void main(String[] args) {
        // BufferedReader in = new BufferedReader(new FileReader(source)
        // PrintWriter out = new PrintWriter("src/io/gadget/report1.txt"))

        String source = "src/io/gadget/input.txt";
        createReport(source);
        createReport2(source);
    }

    private static void createReport(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter("src/io/gadget/report1.txt")) {
            Map<String, Integer> report = in
                    .lines()
                    .map(s -> s.split(","))
                    .collect(Collectors.groupingBy(s -> s[0] + " " + s[1],
                            Collectors.summingInt(p -> Integer.parseInt(p[3]))));
            report.forEach((k, v) -> out.println(k + ", " + v));
            report.forEach((k, v) -> System.out.println(k + ", " + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createReport2(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter("src/io/gadget/report2.txt")) {
            Map<String, Integer> report = in
                    .lines()
                    .map(Report::personFromString)
                    .collect(Collectors.groupingBy(Person::getFullName,
                            Collectors.summingInt(p -> p.getGadget().getPrice())));
            report.forEach((k, v) -> out.println(k + ", " + v));
            report.forEach((k, v) -> System.out.println(k + ", " + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person personFromString(String input) {
        String[] array = input.split(",");
        Gadget gadget = new Gadget(array[2], Integer.parseInt(array[3]));
        return new Person(array[0], array[1], gadget);
    }
}