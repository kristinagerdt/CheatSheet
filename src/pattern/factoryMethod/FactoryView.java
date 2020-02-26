package pattern.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class FactoryView {
    public static void main(String[] args) {
        Factory factory = new CreatorFactory(1);
        Chocolate chocolate_1 = factory.create();
        factory = new CreatorFactory(0);
        Chocolate chocolate_2 = factory.create();

        List<Chocolate> chocolates = new ArrayList<>();
        chocolates.add(chocolate_1);
        chocolates.add(chocolate_2);
        chocolates.forEach(chocolate ->
                System.out.println(chocolate.getClass().getSimpleName() + ": " + chocolate.getPrice()));
    }
}