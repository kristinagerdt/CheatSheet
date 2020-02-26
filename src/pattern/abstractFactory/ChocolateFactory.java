package pattern.abstractFactory;

import pattern.abstractFactory.cake.Cake;
import pattern.abstractFactory.cake.ChocolateCake;
import pattern.abstractFactory.milkCocktail.ChocolateMilkCocktail;
import pattern.abstractFactory.milkCocktail.MilkCocktail;

public class ChocolateFactory implements AbstractFactory {
    @Override
    public Cake getCake() {
        return new ChocolateCake();
    }

    @Override
    public MilkCocktail getMilkCocktail() {
        return new ChocolateMilkCocktail();
    }
}