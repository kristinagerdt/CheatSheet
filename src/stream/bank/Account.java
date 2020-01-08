package stream.bank;

public class Account {
    private String IBANN;
    private Currency currency;

    public Account(String IBANN, Currency currency) {
        this.IBANN = IBANN;
        this.currency = currency;
    }

    public String getIBANN() {
        return IBANN;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{IBANN=" + IBANN + ", currency=" + currency + '}';
    }
}