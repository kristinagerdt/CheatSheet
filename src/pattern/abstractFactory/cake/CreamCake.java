package pattern.abstractFactory.cake;

public class CreamCake implements Cake {
    @Override
    public String getName() {
        return "Cream cake";
    }

    @Override
    public int getPrice() {
        return 35;
    }
}