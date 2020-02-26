package pattern.abstractFactory.cake;

public class ChocolateCake implements Cake {
    @Override
    public String getName() {
        return "Chocolate cake";
    }

    @Override
    public int getPrice() {
        return 50;
    }
}