package pattern.abstractFactory;

import pattern.abstractFactory.cake.Cake;
import pattern.abstractFactory.milkCocktail.MilkCocktail;

public interface AbstractFactory {
    public abstract Cake getCake();

    public abstract MilkCocktail getMilkCocktail();
}

// It is useful in situations when it is necessary to create several instances of different classes at once,
// in some combination, bearing in mind that this combination will be repeated and other combinations also exist