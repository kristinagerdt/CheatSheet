package pattern.abstractFactory.milkCocktail;

public class CreamMilkCocktail implements MilkCocktail {
    @Override
    public String getName() {
        return "Cream milk cocktail";
    }

    @Override
    public int getPrice() {
        return 60;
    }
}