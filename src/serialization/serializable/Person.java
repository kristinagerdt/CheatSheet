package serialization.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Home home;

    public Person(String firstName, String lastName, Home home) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Person{firstName=" + firstName + ", lastName=" + lastName + ", " + home + '}';
    }
}