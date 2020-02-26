package pattern.abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory chocolateFactory = new ChocolateFactory();
        print(chocolateFactory);

        AbstractFactory creamFactory = new CreamFactory();
        print(creamFactory);
    }

    public static void print(AbstractFactory factory) {
        System.out.println(factory.getClass().getSimpleName());
        System.out.println(factory.getCake().getName() + " " + factory.getCake().getPrice());
        System.out.println(factory.getMilkCocktail().getName() + " " + factory.getMilkCocktail().getPrice() + "\n");
    }
}