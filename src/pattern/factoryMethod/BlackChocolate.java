package pattern.factoryMethod;

public class BlackChocolate implements Chocolate {
    private final int price = 10;

    @Override
    public int getPrice() {
        return price;
    }
}