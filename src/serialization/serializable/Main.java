package serialization.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Home home = new Home("3 Baker Street");
        Person person = new Person("Alex", "Smith", home);
        System.out.println("Original: " + person);

        fileSerialization(person);
        byteSerialization(person);
    }

    private static void fileSerialization(Person person) throws IOException, ClassNotFoundException {
        // serialization in file with ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/serialization/serializable/person.out"));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        // deserialization from file with ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src/serialization/serializable/person.out"));
        Person personRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Person restored from file: " + personRestored);
    }

    private static void byteSerialization(Person person) throws IOException, ClassNotFoundException {
        // serialization with ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        // deserialization with ByteArrayInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person personRestoredFromByte = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Person restored from byte: " + personRestoredFromByte);
    }
}

// 3 different objects Home:
//Original: Person{firstName=Alex, lastName=Smith, serialization.Home@2503dbd3}
//Person restored from file: Person{firstName=Alex, lastName=Smith, serialization.Home@1d81eb93}
//Person restored from byte: Person{firstName=Alex, lastName=Smith, serialization.Home@7291c18f}