package pattern.broker;

public class Munchkin implements Game {
    @Override
    public void printName() {
        System.out.println(Munchkin.class.getSimpleName());
    }
}