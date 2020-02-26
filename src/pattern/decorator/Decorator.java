package pattern.decorator;

abstract class Decorator implements Product {
    public final Product product;

    public Decorator(Product product) {
        this.product = product;
    }
}