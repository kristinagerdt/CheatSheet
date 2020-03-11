package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedFilePrintWriterFiles {
    public static void main(String[] args) {
        writeBuffered();
        writeFiles();
    }

    private static void writeBuffered() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/files/output.txt", true));
             PrintWriter out = new PrintWriter(bw)) {
            out.println("\nNew line");
            out.println("and this line");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFiles() {
        try {
            Files.write(Paths.get("src/io/files/output.txt"), "New line too".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}