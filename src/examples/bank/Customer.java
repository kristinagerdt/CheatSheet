package examples.bank;

public class Customer {
    private String name;
    private int age;
    private Account account;

    public Customer(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + ", age=" + age + ", account=" + account + '}';
    }
}