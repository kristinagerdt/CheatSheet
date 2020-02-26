package pattern.decorator;

public class MilkDiscount extends Decorator {
    public MilkDiscount(Product product) {
        super(product);
    }

    @Override
    public int getPrice() {
        return product.getPrice() - 15;
    }
}