package exception.bankCustom;

import exception.entity.Account;
import exception.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alex", 16, new Account("DE21179999123564758823"));
        Customer c2 = new Customer("Nick", 17, new Account("DE21179999123564758824"));
        Customer c3 = new Customer("Stephan", 4, new Account("FR21179999123564758825"));
        Customer c4 = new Customer("Max", 26, new Account("DE2117999912356475"));

        List<Customer> customers = new ArrayList<>();
        Collections.addAll(customers, c1, c2, c3, c4);

        customers.forEach(Main::validate);
    }

    public static void validate(Customer customer) {
        boolean isRightCustomer = true;
        List<String> exceptionList = new LinkedList<>();

        try {
            validateAge(customer.getAge());
        } catch (UnderageCustomerException e) {
            isRightCustomer = false;
            exceptionList.add(e.getMessage() + ", age=" + e.getAge());
        }

        try {
            validateCountryCode(customer.getAccount().getIban());
        } catch (InvalidCountryCodeException e) {
            isRightCustomer = false;
            exceptionList.add(e.getMessage() + ", country=" + e.getCountryCode());
        }

        try {
            validateIbanLength(customer.getAccount().getIban());
        } catch (WrongIbanLengthException e) {
            isRightCustomer = false;
            exceptionList.add(e.getMessage() + ", length=" + e.getIbanLength());
        }

        if (!isRightCustomer) {
            printException(exceptionList, customer.getName());
        }
    }

    public static void printException(List<String> exceptionList, String name) {
        System.out.print(name + ": ");
        String collect = String.join(". ", exceptionList);
        System.out.println(collect);
    }

    private static void validateAge(int age) throws UnderageCustomerException {
        if (age < 17) {
            throw new UnderageCustomerException("Underage customer", age);
        }
    }

    private static void validateCountryCode(String iban) throws InvalidCountryCodeException {
        String countryCode = iban.substring(0, 2);
        if (!countryCode.equals("DE")) {
            throw new InvalidCountryCodeException("Invalid country code", countryCode);
        }
    }

    private static void validateIbanLength(String iban) throws WrongIbanLengthException {
        int ibanLength = iban.length();
        if (ibanLength != 16) {
            throw new WrongIbanLengthException("Wrong length of iban", ibanLength);
        }
    }
}