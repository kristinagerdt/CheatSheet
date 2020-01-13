package examples.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alex", 16, new Account("DE21179999123564758823"));
        Customer c2 = new Customer("Nick", 17, new Account("DE21179999123564758824"));
        Customer c3 = new Customer("Stephan", 4, new Account("FR21179999123564758825"));
        Customer c4 = new Customer("Max", 26, new Account("DE2117999912356475"));
        List<Customer> customers = new ArrayList<>();
        Collections.addAll(customers, c1, c2, c3, c4);

        Optional<Map<Customer, List<String>>> summaryInfo;
        for (Customer customer : customers) {
            summaryInfo = Validator.validateCustomer(customer);
            summaryInfo.ifPresent(Main::printException);
        }
    }

    private static void printException(Map<Customer, List<String>> map) {
        map.forEach((k, v) -> System.out.println(k.getName() + ": " + v));
    }
}