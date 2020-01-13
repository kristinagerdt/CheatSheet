package examples.bank;

import examples.bank.exception.InvalidCountryCodeException;
import examples.bank.exception.UnderAgeCustomerException;
import examples.bank.exception.WrongIbanLengthException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Validator {
    private static Predicate<Integer> checkAge = i -> i < 18;
    private static Predicate<String> checkCountryCode = s -> !s.substring(0, 2).equals("DE");
    private static Predicate<Integer> checkIbanLength = i -> i != 22;

    public static Optional<Map<Customer, List<String>>> validateCustomer(Customer customer) {
        Map<Customer, List<String>> summaryInfo = new HashMap<>();
        List<String> exceptions = new ArrayList<>();

        try {
            validateAge(customer, checkAge);
        } catch (UnderAgeCustomerException e) {
            exceptions.add(e.getMessage() + " (" + e.getAge() + ")");
        }

        try {
            validateCountryCode(customer, checkCountryCode);
        } catch (InvalidCountryCodeException e) {
            exceptions.add(e.getMessage() + " (" + e.getCountryCode() + ")");
        }

        try {
            validateIbanLength(customer, checkIbanLength);
        } catch (WrongIbanLengthException e) {
            exceptions.add(e.getMessage() + " (" + e.getIbanLength() + ")");
        }

        if (!exceptions.isEmpty()) {
            summaryInfo.put(customer, exceptions);
            return Optional.of(summaryInfo);
        }
        return Optional.empty();
    }

    private static void validateAge(Customer customer, Predicate<Integer> p) throws UnderAgeCustomerException {
        int age = customer.getAge();
        if (p.test(age)) throw new UnderAgeCustomerException("Underage customer", age);
    }

    private static void validateCountryCode(Customer customer, Predicate<String> p) throws InvalidCountryCodeException {
        String countryCode = customer.getAccount().getIban().substring(0, 2);
        if (p.test(countryCode)) throw new InvalidCountryCodeException("Invalid country code", countryCode);
    }

    private static void validateIbanLength(Customer customer, Predicate<Integer> p) throws WrongIbanLengthException {
        int ibanLength = customer.getAccount().getIban().length();
        if (p.test(ibanLength)) throw new WrongIbanLengthException("Wrong length of iban", ibanLength);
    }
}