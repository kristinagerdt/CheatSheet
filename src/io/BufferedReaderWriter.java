package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        // FileReader reader = new FileReader("file.txt");
        // BufferedReader in = new BufferedReader(reader);
        // BufferedWriter out = new BufferedWriter(new FileWriter("result.txt")))
        try (BufferedReader in = new BufferedReader(new FileReader("src/io/files/numbers.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("src/io/files/sum.txt"))) {
            Integer sum = in
                    .lines()
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
            out.write(sum.toString());
            System.out.println("Sum=" + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}