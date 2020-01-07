package stream.helper;

public class Person {
    private final String name;
    private final Integer age;
    private final Gender gender;
    private final boolean isAlive;

    public Person(String name, Integer age, Gender gender, boolean isAlive) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", isAlive=" + isAlive +
                '}';
    }
}