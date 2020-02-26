package pattern.factoryMethod;

public class WhiteChocolate implements Chocolate {
    private final int price = 15;

    @Override
    public int getPrice() {
        return price;
    }
}