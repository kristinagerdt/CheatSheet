package pattern.broker;

public class Mafia implements Game {
    @Override
    public void printName() {
        System.out.println(Mafia.class.getSimpleName());
    }
}