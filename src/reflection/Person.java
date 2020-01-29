package reflection;

public class Person {
    private String firstName;
    public String lastName;
    public int age;
    private boolean gender; // true-female, false-male

    public Person(String firstName, String lastName, int age, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void printData() {
        System.out.println("Person{" + firstName + " " + lastName + ", "
                + (age > 0 ? age + " years old, " : "") + (gender ? "Woman" : "Man") + '}');
    }
}