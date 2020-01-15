package io.gadget;

public class Person {
    private String firstName;
    private String lastName;
    private Gadget gadget;

    public Person(String firstName, String lastName, Gadget gadget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gadget = gadget;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{name=" + getFullName() + ", gadget=" + gadget + '}';
    }
}