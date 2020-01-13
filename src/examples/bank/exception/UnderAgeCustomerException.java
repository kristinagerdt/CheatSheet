package examples.bank.exception;

public class UnderAgeCustomerException extends Exception {
    private int age;

    public UnderAgeCustomerException(String message, int age) {
        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}