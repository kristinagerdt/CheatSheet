package io.gadget;

public class Gadget {
    private String model;
    private int price;

    public Gadget(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Gadget{model=" + model + ", price=" + price + '}';
    }
}