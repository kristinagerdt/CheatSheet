package exception.bankContainer;

import exception.entity.Account;
import exception.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alex", 16, new Account("DE21179999123564758823"));
        Customer c2 = new Customer("Nick", 17, new Account("DE21179999123564758824"));
        Customer c3 = new Customer("Stephan", 4, new Account("FR21179999123564758825"));
        Customer c4 = new Customer("Max", 26, new Account("DE2117999912356475"));

        List<Customer> customers = new ArrayList<>();
        Collections.addAll(customers, c1, c2, c3, c4);

        for (Customer c : customers) {
            System.out.println(validate(c));
        }
    }

    public static String validate(Customer customer) {
        List<String> information = new ArrayList<>();
        information.add(customer.getName());

        try {
            if (validateAge(customer)) {
                information.add("adult");
            }
        } catch (ContainerException e) {
            information.add(e.getMessage());
        }

        try {
            if (validateCountry(customer)) {
                information.add("Germany");
            }
        } catch (ContainerException e) {
            information.add(e.getMessage());
        }

        try {
            if (validateLengthOfIban(customer)) {
                information.add("correct");
            }
        } catch (ContainerException e) {
            information.add(e.getMessage());
        }

        return toString(information);
    }

    private static String toString(List<String> info) {
        return info.get(0) + " " + "[Age: " + info.get(1) + ", Country: " + info.get(2) + ", Iban: " + info.get(3) + "]";
    }

    private static boolean validateAge(Customer customer) throws ContainerException {
        int age = customer.getAge();
        if (age < 18) {
            throw new ContainerException("Underage customer (" + age + ")");
        }
        return true;
    }

    public static boolean validateCountry(Customer customer) throws ContainerException {
        String countryCode = customer.getAccount().getIban().substring(0, 2);
        if (!countryCode.equals("DE")) {
            throw new ContainerException("Wrong country (" + countryCode + ")");
        }
        return true;
    }

    public static boolean validateLengthOfIban(Customer customer) throws ContainerException {
        int lengthOfIban = customer.getAccount().getIban().length();
        if (lengthOfIban < 22) {
            throw new ContainerException("Wrong length of iban (" + lengthOfIban + ")");
        }
        return true;
    }
}