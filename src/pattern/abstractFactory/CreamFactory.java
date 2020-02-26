package pattern.abstractFactory;

import pattern.abstractFactory.cake.Cake;
import pattern.abstractFactory.cake.CreamCake;
import pattern.abstractFactory.milkCocktail.CreamMilkCocktail;
import pattern.abstractFactory.milkCocktail.MilkCocktail;

public class CreamFactory implements AbstractFactory {
    @Override
    public Cake getCake() {
        return new CreamCake();
    }

    @Override
    public MilkCocktail getMilkCocktail() {
        return new CreamMilkCocktail();
    }
}