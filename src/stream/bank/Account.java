package stream.bank;

public class Account {
    private String iban;
    private Currency currency;

    public Account(String iban, Currency currency) {
        this.iban = iban;
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{iban=" + iban + ", currency=" + currency + '}';
    }
}