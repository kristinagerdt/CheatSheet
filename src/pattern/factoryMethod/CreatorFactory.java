package pattern.factoryMethod;

public class CreatorFactory extends Factory {
    public CreatorFactory(int flag) {
        super(flag);
    }

    @Override
    public Chocolate create() {
        if (super.getFlag() == 0) return new WhiteChocolate();
        if (super.getFlag() == 1) return new BlackChocolate();
        throw new IllegalArgumentException();
    }
}