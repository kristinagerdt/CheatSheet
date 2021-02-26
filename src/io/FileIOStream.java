package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class FileIOStream {
    public static void main(String[] args) {
        // the resource placed in this way will be closed at the end of use
        // try() to take care of this
        try (InputStream in = new FileInputStream("src/io/files/input.txt");
             OutputStream out = new FileOutputStream("src/io/files/output.txt")) {
            int c; // read bytes, but wrapped in int
            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            //System.out.println(e.getCause());
        }
    }
}