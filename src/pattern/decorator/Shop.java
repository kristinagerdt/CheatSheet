package pattern.decorator;

public class Shop {
    public static void main(String[] args) {
        Product milk = new Milk(50);
        System.out.println("Milk=" + milk.getPrice());

        Product milkDiscount = new MilkDiscount(milk);
        System.out.println("Milk discount=" + milkDiscount.getPrice());
    }
}