package pattern.decorator;

abstract class Decorator implements Product {
    public final Product product;

    public Decorator(Product product) {
        this.product = product;
    }
}

// It is necessary to expand the functionality of an object without modifying this object