package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class CopyFile {
    public static void main(String[] args) {
        String from = "src/io/files/input.txt";
        String to = "src/io/files/copy";
        copyFileIOStream(from, to);
        copyFileIOStreamBuffer(from, to);
        copyFileIOStreamBuffer2(from, to);
    }

    private static void copyFileIOStream(String from, String to) {
        File file = new File(from);
        String pathDest = String.valueOf(Paths.get(to, file.getName()));
        try (InputStream in = new FileInputStream(from);
             OutputStream out = new FileOutputStream(pathDest)) {
            int c;
            while ((c = in.read()) != -1) {
                out.write((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileIOStreamBuffer(String from, String to) {
        File file = new File(from);
        String pathDest = String.valueOf(Paths.get(to, file.getName()));
        try (InputStream in = new FileInputStream(from);
             OutputStream out = new FileOutputStream(pathDest)) {
            byte[] buffer = new byte[256];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileIOStreamBuffer2(String from, String to) {
        File file = new File(from);
        String pathDest = String.valueOf(Paths.get(to, file.getName()));
        try (InputStream in = new FileInputStream(from);
             OutputStream out = new FileOutputStream(pathDest)) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);
            out.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}