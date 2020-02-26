package pattern.abstractFactory.milkCocktail;

public class ChocolateMilkCocktail implements MilkCocktail {
    @Override
    public String getName() {
        return "Chocolate milk cocktail";
    }

    @Override
    public int getPrice() {
        return 87;
    }
}