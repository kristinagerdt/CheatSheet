package pattern.broker;

public class Monopoly implements Game {
    @Override
    public void printName() {
        System.out.println(Monopoly.class.getSimpleName());
    }
}