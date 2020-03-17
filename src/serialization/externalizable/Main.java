package serialization.externalizable;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/serialization/externalizable/login.out";
        Login login = new Login("alex", "alex123");
        System.out.println("Original: " + login);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            out.writeObject(login);
           Login loginRestored = (Login) in.readObject();
            System.out.println("Login restored from file: " + loginRestored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}