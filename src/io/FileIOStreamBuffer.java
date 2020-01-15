package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class FileIOStreamBuffer {
    public static void main(String[] args) {
        // the resource placed in this way will be closed at the end of use
        // try() to take care of this
        try (InputStream in = new FileInputStream("src/io/files/input.txt");
             OutputStream out = new FileOutputStream("src/io/files/output.txt")) {
            byte[] buffer = new byte[128];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read); // write to the file exactly as much as it was read
                System.out.println("Read bytes " + read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}